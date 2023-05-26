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

    private List<Grade> grades = new ArrayList<>();
    
    @GetMapping(value="/")
    public String gradeForm(Model model, @RequestParam(required = false) String name){
        Integer indexGrade = getGradeIndex(name);
        boolean gradeNotExist = indexGrade == -1000;
        
        Grade gradeEmpty = new Grade("","","");
        Grade grade = gradeNotExist ? gradeEmpty : grades.get(indexGrade);
        
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
        Integer indexGrade = getGradeIndex(grade.getName());
        boolean gradeNotExist = indexGrade == -1000;
        
        if(gradeNotExist){
            grades.add(grade);
         }else{
            grades.set(indexGrade, grade);
         }
        return "redirect:/grades";
    }
    public Integer getGradeIndex(String name){
        for(int i = 0; i < grades.size();i++){
            if(grades.get(i).getName().equals(name)) return i;
        }
        return -1000;
    }
    
}
