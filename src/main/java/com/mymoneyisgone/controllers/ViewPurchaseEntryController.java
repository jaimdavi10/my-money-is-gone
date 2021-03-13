package com.mymoneyisgone.controllers;


import com.mymoneyisgone.data.PurchaseEntryRepository;
import com.mymoneyisgone.models.PurchaseEntry;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    public ViewPurchaseEntryController (PurchaseEntryRepository per){
        this.per = per;
    }

    @GetMapping
    public String showPurchaseEntryView (Model model){

        List<PurchaseEntry> entries = (List<PurchaseEntry>) this.per.findAll();
        model.addAttribute("entries", entries);
        return "display-purchase";

    }

}
