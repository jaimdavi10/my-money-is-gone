package com.mymoneyisgone.controllers;


import com.mymoneyisgone.models.Favorite;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/favorite")
public class FavoriteController {

    @GetMapping
    public String showFavoriteForm (Model model){

        model.addAttribute("favorite", new Favorite());
        return "favorite-form";

    }

    @PostMapping
    public String handleFavoriteForm (@ModelAttribute("favorite") Favorite favorite, RedirectAttributes attributes){

        attributes.addFlashAttribute("fullFavorite", favorite.getName()+"  $"+favorite.getPrice()+" ,  from: "+favorite.getPurchaseLocation());
        System.out.println("Price: "+favorite.getPrice());
        System.out.println("Name: "+favorite.getName());
        System.out.println("Purchase Location: "+favorite.getPurchaseLocation());

        return "redirect:/view";

    }

}
