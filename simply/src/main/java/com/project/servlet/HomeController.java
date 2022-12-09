package com.project.servlet;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping
    @RequestMapping("/login")
    public String login() {
        //login page
        return "login";
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
