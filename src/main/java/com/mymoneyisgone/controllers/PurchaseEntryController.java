package com.mymoneyisgone.controllers;


import com.mymoneyisgone.data.PurchaseEntryRepository;
import com.mymoneyisgone.models.PurchaseEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
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

        @GetMapping("/view/{id}")
        public String showPurchase (@PathVariable Long id, Model model){
            PurchaseEntry purchaseEntry = this.per.findById(id).get();
            model.addAttribute("purchaseEntry", purchaseEntry);
            return "view-purchase";
        }

        @PostMapping
        public String handlePurchaseEntryForm (@Valid @ModelAttribute("entry") PurchaseEntry purchaseEntry, Errors errors){

            if(errors.hasErrors())
                return "purchase-entry";

            this.per.save(purchaseEntry);

            return "redirect:/view";

        }

        @PostMapping("/edit/{id}")
        public String handleEditPurchaseForm(@PathVariable Long id, @Valid @ModelAttribute("entry") PurchaseEntry purchaseEntry, Errors errors){

            if(errors.hasErrors())
                return "view-purchase";

            PurchaseEntry originalEntry = this.per.findById(id).get();
            updateOriginalPurchase(originalEntry, purchaseEntry);
            this.per.save(originalEntry);

            return "redirect:/view";
        }

        private void updateOriginalPurchase(PurchaseEntry original, PurchaseEntry update){
            original.setPrice(update.getPrice());
            original.setName(update.getName());
            original.setPurchaseLocation(update.getPurchaseLocation());

        }

        @GetMapping("/delete/{id}")
        public String deleteEntry(@PathVariable Long id){

            this.per.deleteById(id);
            return "redirect:/view";

        }

    }

