package com.project.servlet;

import com.project.dbservice.DBAccessService;
import com.project.entity.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {
    @Autowired
    private DBAccessService db;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping
    @RequestMapping( "/login" )
    public String login( Model model, @RequestParam( name = "admin", required = false, defaultValue = "false" ) boolean isAdmin )
    {
        model.addAttribute( "isAdmin", isAdmin );
        //login page
        return "login";
    }

    @GetMapping
    @RequestMapping( "/adminPortal" )
    public String adminPortal( Model model )
    {
        List<ProductEntity> brew = db.getProductCategory( "brew" );
        model.addAttribute( "brew", brew );
        List<ProductEntity> merch = db.getProductCategory( "merch" );
        model.addAttribute( "merch", merch );
        List<ProductEntity> beans = db.getProductCategory( "beans" );
        model.addAttribute( "beans", beans );

        //admin portal page
        return "stock-management";
    }

    @GetMapping
    @RequestMapping("/contact")
    public String contact() {
        //login page
        return "contact";
    }

    @GetMapping
    @RequestMapping("/about")
    public String about() {
        //login page
        return "about";
    }

}
