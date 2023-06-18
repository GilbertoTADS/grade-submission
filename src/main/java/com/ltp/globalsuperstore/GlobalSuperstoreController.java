package com.ltp.globalsuperstore;

import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class GlobalSuperstoreController { 
    
    @GetMapping("/")
    public String getForm(Model model){
        ProductEntity product = new ProductEntity();
        model.addAttribute("categories", Constants.CATEGORIES);
        model.addAttribute("product", product);
        return "form";
    }
     @GetMapping("/edite")
     public String updateForm(Model model, @RequestParam(required = true) String id){
        ProductEntity product = InventoryEntity.getById(id);
        model.addAttribute("categories", Constants.CATEGORIES);
        model.addAttribute("product", product);
        model.addAttribute("action", "update");
        return "form";
     }
}
