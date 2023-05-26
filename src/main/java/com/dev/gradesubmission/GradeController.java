package com.dev.gradesubmission;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GradeController {

    private GradesUtil grades = new GradesUtil();
    
    @GetMapping(value="/")
    public String gradeForm(Model model, @RequestParam(required = false) String name){
        Integer indexGrade = grades.getIndex(name);
        
        Grade gradeEmpty = new Grade("","","");
        Grade grade = grades.notExist(name) ? gradeEmpty : grades.get(indexGrade);
        
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
        Integer indexGrade = grades.getIndex(grade.getName());
        
        if(grades.exists(grade.getName())){
            grades.add(grade);
         }else{
            grades.set(indexGrade, grade);
         }
        return "redirect:/grades";
    }
}
