package com.project.servlet;

import com.project.dbservice.DBAccessService;
import com.project.entity.ProductEntity;
import com.project.entity.UserEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping( "/" )
public class HomeController
{
    private static final String IS_ADMIN_AUTH = "isAdminAuth";
    private static final String IS_NORMAL_AUTH = "isAuth";

    @Autowired
    private DBAccessService db;

    @GetMapping( "/" )
    public String index( Model model, Authentication auth )
    {
        setAuthParameters( model, auth );
        return "index";
    }

    @GetMapping
    @RequestMapping( "/login" )
    public String login( Model model, Authentication auth, @RequestParam( name = "admin", required = false, defaultValue = "false" ) boolean isAdmin )
    {
        model.addAttribute( "isAdmin", isAdmin );
        //login page
        return "login";
    }

    @GetMapping
    @RequestMapping( "/account" )
    public String accountInfo( Model model, Authentication auth )
    {
        if( auth != null && auth.isAuthenticated() )
        {
            Optional<UserEntity> oUser = db.findUserByEmail( auth.getName() );
            if( oUser.isPresent() )
            {
                model.addAttribute( "orders", db.getOrders( oUser.get().getId() ) );
                setAuthParameters( model, auth );
                return "account";
            }
        }
        return "login";
    }

    @GetMapping
    @RequestMapping( "/adminPortal" )
    public String adminPortal( Model model, Authentication auth )
    {
        if( auth != null && auth.isAuthenticated() )
        {
            List<ProductEntity> brew = db.getProductCategory( "brew" );
            model.addAttribute( "brew", brew );
            List<ProductEntity> merch = db.getProductCategory( "merch" );
            model.addAttribute( "merch", merch );
            List<ProductEntity> beans = db.getProductCategory( "beans" );
            model.addAttribute( "beans", beans );
            setAuthParameters( model, auth );
            return "stock-management";
        }
        model.addAttribute( "isAdmin", true );
        return "login";
    }

    @GetMapping
    @RequestMapping( "/contact" )
    public String contact( Model model, Authentication auth )
    {
        setAuthParameters( model, auth );
        return "contact";
    }

    @GetMapping
    @RequestMapping( "/about" )
    public String about( Model model, Authentication auth )
    {
        setAuthParameters( model, auth );
        return "about";
    }

    private void setAuthParameters( Model model, Authentication auth )
    {
        if( auth == null )
        {
            model.addAttribute( IS_ADMIN_AUTH, false );
            model.addAttribute( IS_NORMAL_AUTH, false );
            return;
        }

        Optional<UserEntity> oUser = db.findUserByEmail( auth.getName() );
        if( !oUser.isPresent() )
        {
            model.addAttribute( IS_ADMIN_AUTH, false );
            model.addAttribute( IS_NORMAL_AUTH, false );
            return;
        }

        if( oUser.get().isAdmin() )
        {
            model.addAttribute( IS_ADMIN_AUTH, true );
            model.addAttribute( IS_NORMAL_AUTH, false );
            return;
        }
        model.addAttribute( IS_ADMIN_AUTH, false );
        model.addAttribute( IS_NORMAL_AUTH, true );
    }
}
