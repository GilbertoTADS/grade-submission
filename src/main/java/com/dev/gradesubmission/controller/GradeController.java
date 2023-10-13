package com.dev.gradesubmission.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

    GradeService gradeService;
    
    @Autowired
    public GradeController(GradeService gradeService){
        this.gradeService = gradeService;    
    }
    @GetMapping(value="/")
    public String gradeForm(Model model, @RequestParam(required = false) String id){
        model.addAttribute("grade", gradeService.getGradeBy(id));
        return "form";
    }
    @GetMapping(value="/grades")
    public String getGrades(Model model){
        model.addAttribute("grades", gradeService.getAll());
        return "grades";
    }
    @PostMapping("/handleSubmit")
    public String submitGrade(@Valid Grade grade, BindingResult result ){
        if(result.hasErrors()) return "form";
        gradeService.submiGrade(grade);
        return "redirect:/grades";
    }
}