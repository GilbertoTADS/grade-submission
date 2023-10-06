package com.dev.gradesubmission.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dev.gradesubmission.Grade;
import com.dev.gradesubmission.repository.GradeRepository;

@Controller
public class GradeController {

    GradeRepository gradeRepo = new GradeRepository();
    
    @GetMapping(value="/")
    public String gradeForm(Model model, @RequestParam(required = false) String id){
        int indexGrade = gradeRepo.getIndex(id);
        System.out.println(indexGrade +" id searched:"+id);
        for(Grade g:gradeRepo){
            System.out.println("ID existent: "+g.getId());
            System.out.println("not exist ? "+ gradeRepo.notExist(id));
        }
        Grade gradeEmpty = new Grade();
        Grade grade = gradeRepo.notExist(id) ? gradeEmpty : gradeRepo.get(indexGrade);
        
        model.addAttribute("grade", grade);
        return "form";
    }
    @GetMapping(value="/grades")
    public String getGrades(Model model){
        model.addAttribute("grades", gradeRepo);
        return "grades";
    }
    @PostMapping("/handleSubmit")
    public String submitGrade(@Valid Grade grade, BindingResult result ){
        if(result.hasErrors()) return "form";
        Integer indexGrade = gradeRepo.getIndex(grade.getId());
        
        if(gradeRepo.notExist(grade.getId())){
            gradeRepo.add(grade);
         }else{
            gradeRepo.set(indexGrade, grade);
         }
        return "redirect:/grades";
    }
}