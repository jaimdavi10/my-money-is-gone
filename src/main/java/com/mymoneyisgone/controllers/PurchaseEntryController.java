package com.mymoneyisgone.controllers;


import com.mymoneyisgone.models.PurchaseEntry;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;



    @Controller
    @RequestMapping("/entry")
    public class PurchaseEntryController {

        @GetMapping
        public String showPurchaseEntryForm (Model model){

            model.addAttribute("entry", new PurchaseEntry());
            return "purchase-entry";

        }

        @PostMapping
        public String handlePurchaseEntryForm (@ModelAttribute("purchaseEntry") PurchaseEntry purchaseEntry, RedirectAttributes attributes){

            attributes.addFlashAttribute("fullEntry", purchaseEntry);
            System.out.println("Price: "+purchaseEntry.getPrice());
            System.out.println("Name: "+purchaseEntry.getName());
            System.out.println("Purchase Location: "+purchaseEntry.getPurchaseLocation());

            return "redirect:/view";

        }

    }

