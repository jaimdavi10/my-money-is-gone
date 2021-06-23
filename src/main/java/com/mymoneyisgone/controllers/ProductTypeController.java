package com.mymoneyisgone.controllers;

import com.mymoneyisgone.data.ProductTypeRepository;
import com.mymoneyisgone.models.ProductType;
import com.mymoneyisgone.models.PurchaseEntry;
import com.mymoneyisgone.models.User;
import com.mymoneyisgone.service.PurchaseEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/product-types")
public class ProductTypeController {

    private ProductTypeRepository ptr;
    private PurchaseEntryService pes;


    @Autowired
    public ProductTypeController(ProductTypeRepository ptr, PurchaseEntryService pes){

        this.ptr = ptr;
        this.pes = pes;

    }


    @GetMapping("/view")
    public String showProductTypes(Model model){
        List<ProductType> productTypes = (List<ProductType>) this.ptr.findAll();
        model.addAttribute("productTypes", productTypes);
        return "display-product-types";
    }

    @GetMapping("/Food")
    public String showFoodEntries (@AuthenticationPrincipal User user, Model model) {

        List<PurchaseEntry> list = pes.byProductType("Food", user);
        model.addAttribute("list", list);
        return "display-selected-entries";

    }

    @GetMapping("/Technology")
    public String showTechnologyEntries (@AuthenticationPrincipal User user, Model model) {

        List<PurchaseEntry> list = pes.byProductType("Technology", user);
        model.addAttribute("list", list);
        return "display-selected-entries";

    }

    @GetMapping("/Outings")
    public String showOutingsEntries (@AuthenticationPrincipal User user, Model model) {

        List<PurchaseEntry> list = pes.byProductType("Outings", user);
        model.addAttribute("list", list);
        return "display-selected-entries";

    }

    @GetMapping("/Entertainment")
    public String showEntertainmentEntries (@AuthenticationPrincipal User user, Model model) {

        List<PurchaseEntry> list = pes.byProductType("Entertainment", user);
        model.addAttribute("list", list);
        return "display-selected-entries";

    }

    @GetMapping("/Fashion")
    public String showFashionEntries (@AuthenticationPrincipal User user, Model model) {

        List<PurchaseEntry> list = pes.byProductType("Fashion", user);
        model.addAttribute("list", list);
        return "display-selected-entries";

    }

    @GetMapping("/Other")
    public String showOtherEntries (@AuthenticationPrincipal User user, Model model) {

        List<PurchaseEntry> list = pes.byProductType("Other", user);
        model.addAttribute("list", list);
        return "display-selected-entries";

    }


}
