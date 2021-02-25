package com.mymoneyisgone.controllers;

import com.mymoneyisgone.models.Favorite;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/view")
public class ViewFavoriteController {

    @GetMapping
    public String showFavoriteView (@ModelAttribute("fullFavorite") Object flashAttribute, Model model){

        model.addAttribute("fullFavorite", flashAttribute);
        return "display-favorite";

    }

}
