package com.dev.gradesubmission;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GradeController {

    private GradesUtil grades = new GradesUtil();
    
    @GetMapping(value="/")
    public String gradeForm(Model model, @RequestParam(required = false) String id){
        int indexGrade = grades.getIndex(id);
        System.out.println(indexGrade +" id searched:"+id);
        for(Grade g:grades){
            System.out.println("ID existent: "+g.getId());
            System.out.println("not exist ? "+ grades.notExist(id));
        }
        Grade gradeEmpty = new Grade();
        Grade grade = grades.notExist(id) ? gradeEmpty : grades.get(indexGrade);
        
        model.addAttribute("grade", grade);
        return "form";
    }
    @GetMapping(value="/grades")
    public String getGrades(Model model){
        model.addAttribute("grades", grades);
        return "grades";
    }
    @PostMapping("/handleSubmit")
    public String submitGrade(@Valid Grade grade, BindingResult result ){
        if(result.hasErrors()) return "form";
        Integer indexGrade = grades.getIndex(grade.getId());
        
        if(grades.notExist(grade.getId())){
            grades.add(grade);
         }else{
            grades.set(indexGrade, grade);
         }
        return "redirect:/grades";
    }
}