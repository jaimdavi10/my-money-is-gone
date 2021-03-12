package com.mymoneyisgone.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/view")
public class ViewPurchaseEntryController {

    @GetMapping
    public String showPurchaseEntryView (Model model){


        return "display-purchase";

    }

}
