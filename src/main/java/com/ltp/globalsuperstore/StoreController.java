package com.ltp.globalsuperstore;

import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class StoreController { 
    
    @GetMapping("/")
    public String getForm(Model model){
        Product product = new Product();
        model.addAttribute("categories", Constants.CATEGORIES);
        model.addAttribute("product", product);
        return "form";
    }
     @GetMapping("/edite")
     public String updateForm(Model model, @RequestParam(required = true) String id){
        Product product = InventoryEntity.getById(id);
        model.addAttribute("categories", Constants.CATEGORIES);
        model.addAttribute("product", product);
        model.addAttribute("action", "update");
        return "form";
     }
}
