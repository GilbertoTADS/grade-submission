package com.dev.gradesubmission;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GradeController {

    @GetMapping("/grades")
    public String getGrades(Model model){
        Grade grade = new Grade("Harry", "CSS", "C-");
        model.addAttribute("grade", grade);
        return "grades";
    }
    
}
