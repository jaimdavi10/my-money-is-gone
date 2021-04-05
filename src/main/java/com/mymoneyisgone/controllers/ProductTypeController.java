package com.mymoneyisgone.controllers;

import com.mymoneyisgone.data.ProductTypeRepository;
import com.mymoneyisgone.models.ProductType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/product-types")
public class ProductTypeController {

    private ProductTypeRepository ptr;

    @Autowired
    public ProductTypeController(ProductTypeRepository ptr){
        this.ptr = ptr;
    }

    @GetMapping("/view")
    public String showProductTypes(Model model){
        List<ProductType> productTypes = (List<ProductType>) this.ptr.findAll();
        model.addAttribute("productTypes", productTypes);
        return "display-product-types";
    }
}
