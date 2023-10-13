package com.dev.gradesubmission.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dev.gradesubmission.Grade;
import com.dev.gradesubmission.service.GradeService;

@Controller
public class GradeController {

    GradeService gradeService = new GradeService();

    @GetMapping(value="/")
    public String gradeForm(Model model, @RequestParam(required = false) String id){
        int indexGrade = gradeService.getIndex(id);
        System.out.println(indexGrade +" id searched:"+id);
        Grade gradeEmpty = new Grade();
        Grade grade = gradeService.notExist(id) ? gradeEmpty : gradeService.get(indexGrade);
        
        model.addAttribute("grade", grade);
        return "form";
    }
    @GetMapping(value="/grades")
    public String getGrades(Model model){
        model.addAttribute("grades", gradeService);
        return "grades";
    }
    @PostMapping("/handleSubmit")
    public String submitGrade(@Valid Grade grade, BindingResult result ){
        if(result.hasErrors()) return "form";
        Integer indexGrade = gradeService.getIndex(grade.getId());
        
        if(gradeService.notExist(grade.getId())){
            gradeService.add(grade);
         }else{
            gradeService.set(indexGrade, grade);
         }
        return "redirect:/grades";
    }
}