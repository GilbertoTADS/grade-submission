package com.dev.gradesubmission.repository;

import java.util.List;

import com.dev.gradesubmission.Constants;
import com.dev.gradesubmission.Grade;

import java.util.ArrayList;

public class GradeRepository extends ArrayList<Grade>{
    Grade auxGrade = new Grade();

    public GradeRepository(){}

    GradeRepository(List<Grade> grades){
        super(grades);
    }
    public Integer getIndex(String id){
        auxGrade.setId(id);
        boolean contain = false;
        for(Grade g:this){
            if(g.equals(auxGrade)) return this.indexOf(g);
        }
        return contain ? this.indexOf(auxGrade) : -1000;
    }
    public boolean exists(String id){
        return !notExist(id);
    }
    public boolean notExist(String id){
        return getIndex(id) == Constants.NOT_FOUND;
    }

    public List<Grade> getAll() {
        try{
            ArrayList<Grade> clone = new ArrayList<>();
            for(Grade grade:this){
                clone.add(grade.clone());
            }
            return clone;
        }catch(CloneNotSupportedException e){
            System.err.println(e);
            return new ArrayList<Grade>();
        }
        
    }
}
