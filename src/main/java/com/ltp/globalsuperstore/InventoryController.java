package com.ltp.globalsuperstore;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class InventoryController{
    private static final String addItemSuccessly = "You successfully submit the item!";
    private static final String error = "Some error occurs!";

    @GetMapping("/inventory")
    public String getForm(Model model){
         model.addAttribute("products", InventoryEntity.getProducts());
        return "inventory";
    }
    @PostMapping("/")
    public String submitIsValid(@Valid Product product,BindingResult validator, RedirectAttributes redirAttr){
        if(validator.hasErrors()) return "form";
        boolean success = InventoryEntity.add(product);
        redirAttr.addFlashAttribute(Constants.SUCCESS_STATUS, success);
        redirAttr.addFlashAttribute(Constants.MESSAGE, success ? addItemSuccessly : error);
        return "redirect:/inventory";
    }
    @PostMapping("/update")
    public String update(Model model,RedirectAttributes redirAttr,Product product){
        InventoryEntity.update(product);
        model.addAttribute("products", InventoryEntity.getProducts());
        redirAttr.addFlashAttribute(Constants.SUCCESS_STATUS, addItemSuccessly);
        return "inventory";
    }

}
