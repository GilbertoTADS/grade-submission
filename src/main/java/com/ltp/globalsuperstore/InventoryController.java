package com.ltp.globalsuperstore;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class InventoryController{

    @GetMapping("/inventory")
    public String getForm(Model model){

        return "inventory";
    }
    @PostMapping("/")
    public String submit(Model model,ProductEntity product){
        InventoryEntity.add(product);
        model.addAttribute("products", InventoryEntity.getProducts());
        System.out.println(InventoryEntity.getProducts());
        return "inventory";
    }
}
