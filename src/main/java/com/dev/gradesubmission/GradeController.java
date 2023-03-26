package com.dev.gradesubmission;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GradeController {

    private List<Grade> grades = new ArrayList<>();
    
    @GetMapping(value="/")
    public String gradeForm(Model model){
        Grade grade = new Grade("","","");
        model.addAttribute("grade", grade);
        return "form";
    }
                            
    @GetMapping(value="/grades")
    public String getGrades(Model model){
        model.addAttribute("grades", grades);
        return "grades";
    }
    @PostMapping("/handleSubmit")
    public String submitGrade(Grade grade){
        grades.add(grade);
        return "redirect:/grades";
    }
    
}
