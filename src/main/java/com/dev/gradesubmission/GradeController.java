package com.dev.gradesubmission;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GradeController {

    List<Grade> grades = Arrays.asList(
                            new Grade("Harry", "CSS", "C-"),
                            new Grade("Hermione", "Arithmetric", "A+"),
                            new Grade("Neville", "Charms", "A-"));
    
    @GetMapping(value="/")
    public String gradeForm(Model model){
        Grade grade = new Grade("Guilbert","Spring MVC","100");
        model.addAttribute("grade", grade);
        return "form";
    }
                            
    @GetMapping(value="/grades")
    public String getGrades(Model model){
        model.addAttribute("grades", grades);
        return "grades";
    }
    
}
