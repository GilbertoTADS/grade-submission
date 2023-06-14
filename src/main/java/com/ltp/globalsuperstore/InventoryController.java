package com.ltp.globalsuperstore;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class InventoryController{

    @GetMapping("/inventory")
    public String getForm(Model model){
         model.addAttribute("products", InventoryEntity.getProducts());
        return "inventory";
    }
    @PostMapping("/")
    public String submit(Model model,RedirectAttributes redirAttr, ProductEntity product){
        boolean success = InventoryEntity.add(product);
        redirAttr.addFlashAttribute("success", success);
        redirAttr.addFlashAttribute("message", success ? "You successfully submit the item!" : "Some error occurs!");
        return "redirect:/inventory";
    }
    @PostMapping("/update")
    public String update(Model model,RedirectAttributes redirAttr,ProductEntity product){
        InventoryEntity.update(product);
        model.addAttribute("products", InventoryEntity.getProducts());
        redirAttr.addFlashAttribute("success", "You successfully update the item!");
        return "inventory";
    }

}
