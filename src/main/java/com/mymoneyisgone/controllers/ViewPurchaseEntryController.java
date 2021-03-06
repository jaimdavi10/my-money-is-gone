package com.mymoneyisgone.controllers;


import com.mymoneyisgone.data.PurchaseEntryRepository;
import com.mymoneyisgone.data.UserRepository;
import com.mymoneyisgone.models.PurchaseEntry;
import com.mymoneyisgone.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/view")
public class ViewPurchaseEntryController {

    private PurchaseEntryRepository per;
    private UserRepository ur;

    @Autowired
    public ViewPurchaseEntryController (PurchaseEntryRepository per, UserRepository ur){
        this.per = per;
        this.ur = ur;
    }

    @GetMapping
    public String showPurchaseEntryView (@AuthenticationPrincipal User user, Model model){
//        List<PurchaseEntry> entries = (List<PurchaseEntry>) this.per.findAll();
        user = ur.findByUsername(user.getUsername());
        model.addAttribute("entries", user.getPurchaseEntrySet());
        return "display-purchase";
    }

}
