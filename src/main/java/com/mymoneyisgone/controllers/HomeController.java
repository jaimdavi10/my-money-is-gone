package com.mymoneyisgone.controllers;

import com.mymoneyisgone.models.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public String getHomePage(Model model, @AuthenticationPrincipal User user){

        model.addAttribute("user" , user);
        return "index";

    }

    @GetMapping("/login")
    public String getLoginPage(){
        return "login";
    }

}
