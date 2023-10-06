package com.dev.gradesubmission.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WorkbookController {
    
    @GetMapping(value="/utility-methods")
    public String getNameMethod(Model model){
        model.addAttribute("menu", "We sell chocolate rice cakes buble tea");
        return "view";
    }
}
