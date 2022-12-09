package com.project.servlet;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.project.dbservice.DBAccessService;
import com.project.entity.UserEntity;
import java.util.HashSet;
import java.util.Set;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Servlet implementation class SignupServlet ENDPOINT RENAMED TO /user
 */
@Controller
@RequestMapping("/user")
//TODO rename to Signup Controller
public class SignupServlet {

    Logger logger = LoggerFactory.getLogger(SignupServlet.class);
    
    @Autowired
    private DBAccessService db;
    
    @GetMapping
    public String signup(Model model) {
        model.addAttribute("user", new UserEntity());
        return "signup";
    }
    
    @PostMapping
    public String doPost(@Valid @ModelAttribute("user") UserEntity user, BindingResult br, Model model) {
        System.out.println("user = " + user);
        if (!br.hasErrors()) {
            try {
//                UserEntity user = new UserEntity();
//                user.setPassword(request.getParameter("password"));
//                String confirmPassword = request.getParameter("confirmPassword");
//                // TODO: Compare if passwords are same
//                user.setFirstName(request.getParameter("fname"));
//                user.setLastName(request.getParameter("lname"));
//                user.setBillingAddr(request.getParameter("ba"));
//                user.setShipping_Addr(request.getParameter("sa"));
//                user.setEmail(request.getParameter("email"));
//                user.setCcnum(Integer.parseInt(request.getParameter("cc")));
//                user.setCcexp(request.getParameter("expiry"));
//                user.setCccvv(Integer.parseInt(request.getParameter("cvv")));
                // sign up user
                if (db.signUp(user)) {
                    // automatically login
                    System.out.println("Customer Successfully Signed Up");
                    final SimpleGrantedAuthority userAuthority = new SimpleGrantedAuthority("USER");
                    Set<SimpleGrantedAuthority> authorities = new HashSet<>();
                    authorities.add(userAuthority);
                    Authentication auth = new UsernamePasswordAuthenticationToken(user.getEmail(), null, authorities);
                    SecurityContextHolder.getContext().setAuthentication(auth);
                    return "redirect:/cart";
                } else {
                    model.addAttribute("error", "Customer Failed SignUp");
                }
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
                model.addAttribute("error", "Something Went Wrong");
            }
        } else {
            System.out.println("br = " + br.getFieldErrors());
            model.addAttribute("error", "Validation Error. Check Required Fields");
        }
        return "signup";

        // redirect to index after login
//        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
    
}
