package com.project;

import com.project.dbservice.DBAccessService;
import com.project.entity.UserEntity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Configuration
public class SecurityConfiguration {

    private static final Logger LOGGER = LoggerFactory.getLogger(SecurityConfiguration.class);

    @Autowired
    private DBAccessService db;

    @Bean
    public SecurityFilterChain configure( HttpSecurity http ) throws Exception {
        http.antMatcher( "/**" ).authorizeRequests()
            .antMatchers( "/resources/**", "/static/**", "/css/**", "/js/**", "/revolution/**" ).permitAll()
            .antMatchers( "/cart/**" ).authenticated()
            .antMatchers( "/checkout/**" ).authenticated()
            //user should not be logged in
            .antMatchers( "/signup" ).anonymous()
            //user should not be logged in
            .antMatchers( "/login" ).anonymous()
            //only signup if not logged in
            .antMatchers( "/user" ).anonymous()
            //default to permit all
            //only secure specific urls
            .anyRequest().permitAll()
            .and()
            //disable for now
            .csrf( AbstractHttpConfigurer::disable )
            .cors()
            .and()
            .formLogin( login -> login.loginPage( "/login" ).usernameParameter( "email" ).passwordParameter( "password" )
                                      .loginProcessingUrl( "/login" )
                                      .successHandler( new SavedRequestAwareAuthenticationSuccessHandler()
                                      {

                                          @Override
                                          public void onAuthenticationSuccess( HttpServletRequest request, HttpServletResponse response, Authentication authentication ) throws ServletException, IOException
                                          {
                                              LOGGER.info( "Successfully Authenticated {}", authentication.getName() );
                                              Optional<UserEntity> oUser = db.findUserByEmail( authentication.getName() );
                                              if( oUser.isPresent() && oUser.get().isAdmin() )
                                              {
                                                  response.sendRedirect( request.getContextPath() + "/adminPortal" );
                                              }
                                              super.onAuthenticationSuccess( request, response, authentication );
                                          }
                                      } )
                                      .failureHandler( ( request, response, exception ) ->
                                      {
                                          LOGGER.info( "Authentication Failed For {}", request.getParameter( "email" ) );
                                          response.sendRedirect( request.getContextPath() + "/login?error=true" );
                                      } ).permitAll() ).authenticationProvider( authenticationProvider() )
            .logout( logout -> logout.logoutUrl( "/logout" )
                                     .deleteCookies( "JSESSIONID" )
                                     .invalidateHttpSession( true )
                                     .logoutSuccessUrl( "/" ) );
        return http.build();
    }

    @Autowired
    private DBAccessService dbas;

    private AuthenticationProvider authenticationProvider() {
        return new AuthenticationProvider() {
            @Override
            public Authentication authenticate(Authentication a) throws AuthenticationException {
                String name = a.getName();
                String password = a.getCredentials().toString();
                if (name != null && password != null) {
                    Optional<UserEntity> oUser = dbas.findUserByEmail(name);
                    if (oUser.isPresent()) {
                        UserEntity user = oUser.get();
                        if (user.getPassword().equals(password)) {
                            final SimpleGrantedAuthority userAuthority = new SimpleGrantedAuthority("USER");
                            Set<SimpleGrantedAuthority> authorities = new HashSet<>();
                            authorities.add(userAuthority);
                            if (user.isAdmin()) {
                                final SimpleGrantedAuthority adminAuthority = new SimpleGrantedAuthority("ADMIN");
                                authorities.add(adminAuthority);
                            }
                            return new UsernamePasswordAuthenticationToken(name, name, authorities);
                        } else {
                            throw new BadCredentialsException("Bad Credentials");
                        }
                    } else {
                        throw new UsernameNotFoundException("User not found");
                    }
                } else {
                    throw new BadCredentialsException("Bad Credentials");
                }
            }

            @Override
            public boolean supports(Class<?> type) {
                return UsernamePasswordAuthenticationToken.class.equals(type);
            }
        };
    }

}
