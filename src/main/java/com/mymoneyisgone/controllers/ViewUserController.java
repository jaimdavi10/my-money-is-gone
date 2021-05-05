package com.mymoneyisgone.controllers;

import com.mymoneyisgone.data.PurchaseEntryRepository;
import com.mymoneyisgone.data.UserRepository;
import com.mymoneyisgone.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user-view")
public class ViewUserController {

    private UserRepository ur;

    @Autowired
    public ViewUserController ( UserRepository ur){

        this.ur = ur;
    }

    @GetMapping
    public String showUserView (@AuthenticationPrincipal User user, Model model){
//        List<PurchaseEntry> entries = (List<PurchaseEntry>) this.per.findAll();
        user = ur.findByUsername(user.getUsername());
        model.addAttribute("user", user);
        return "purchase-entry";
    }

}
