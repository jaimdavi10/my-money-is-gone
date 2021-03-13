package com.mymoneyisgone.controllers;


import com.mymoneyisgone.data.PurchaseEntryRepository;
import com.mymoneyisgone.models.PurchaseEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;


@Controller
    @RequestMapping("/entry")
    public class PurchaseEntryController {

        private PurchaseEntryRepository per;

        @Autowired
        public PurchaseEntryController (PurchaseEntryRepository per){
            this.per = per;
        }

        @GetMapping
        public String showPurchaseEntryForm (Model model){

            model.addAttribute("entry", new PurchaseEntry());
            return "purchase-entry";

        }

        @PostMapping
        public String handlePurchaseEntryForm (@Valid @ModelAttribute("entry") PurchaseEntry purchaseEntry, Errors errors){

            if(errors.hasErrors())
                return "purchase-entry";

            this.per.save(purchaseEntry);

            return "redirect:/view";

        }

    }

