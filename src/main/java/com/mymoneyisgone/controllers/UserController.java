package com.mymoneyisgone.controllers;


import com.mymoneyisgone.data.UserRepository;
import com.mymoneyisgone.models.ProductType;
import com.mymoneyisgone.models.PurchaseEntry;
import com.mymoneyisgone.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    private UserRepository ur;

    @Autowired
    public UserController (UserRepository ur) {
        this.ur = ur;
    }

    @GetMapping
    public String showUserForm (Model model){

        model.addAttribute("user", new User());
        return "user-registration";

    }

    @GetMapping("/view/{id}")
    public String showUser (@PathVariable Long id, Model model){


        User user = this.ur.findById(id).get();
        model.addAttribute("user", user);
        return "view-user";
    }

    @PostMapping
    public String handleUserForm (@Valid @ModelAttribute("user") User user, Errors errors){

        if(errors.hasErrors())
            return "user-registration";


        this.ur.save(user);

        return "redirect:/login";

    }

    @PostMapping("/edit/{id}")
    public String handleEditUserForm(@PathVariable Long id, @Valid @ModelAttribute("user") User user, Errors errors){

        if(errors.hasErrors())
            return "view-user";

        User tempUser = this.ur.findById(id).get();
        updateOriginalUser(tempUser, user);
        this.ur.save(tempUser);

        return "redirect:/";
    }

    private void updateOriginalUser(User original, User update){
        original.setUsername(update.getUsername());
        original.setEmail(update.getEmail());
        original.setFirstName(update.getFirstName());
        original.setLastName(update.getLastName());
        original.setPassword(update.getPassword());
    }





}
