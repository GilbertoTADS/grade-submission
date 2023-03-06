package com.dev.gradesubmission;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ConditionalController {

    @GetMapping(value="/")
    public String getMethodName(Model model){
        model.addAttribute("sales",3);
        model.addAttribute("product", "table");
        
        return "conditionals";
    }
}
