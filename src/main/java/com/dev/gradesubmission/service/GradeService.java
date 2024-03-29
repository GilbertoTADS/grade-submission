package com.dev.gradesubmission.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.gradesubmission.Grade;
import com.dev.gradesubmission.repository.GradeRepository;

@Service
public class GradeService {
    
    private GradeRepository gradeRepo;

    @Autowired
    public GradeService(GradeRepository gradeRepo){
        this.gradeRepo = gradeRepo;
    }
    public List<Grade> getAll() {
        return gradeRepo.getAll();
    }
    public Grade set(int index, Grade element) {
        return gradeRepo.set(index, element);
    }
    public Grade get(int index) {
        return gradeRepo.get(index);
    }
    public Integer getIndex(String id) {
        return gradeRepo.getIndex(id);
    }
    public boolean exists(String id) {
        return gradeRepo.exists(id);
    }

    public boolean notExist(String id) {
        return gradeRepo.notExist(id);
    }

    public boolean add(Grade e) {
        return gradeRepo.add(e);
    }

    public void add(int index, Grade element) {
        gradeRepo.add(index, element);
    }
    public Grade getGradeBy(String id){
        Integer indexGrade = this.getIndex(id);
        Grade gradeEmpty = new Grade();
        return this.notExist(id) ? gradeEmpty : this.get(indexGrade);
    }
    public Grade submiGrade(Grade grade){
        Integer indexGrade = this.getIndex(grade.getId());
        
        if(this.notExist(grade.getId())){
            this.add(grade);
         }else{
            this.set(indexGrade, grade);
         }
         return this.getGradeBy(grade.getId());
    }
}
