package com.dev.gradesubmission;

import java.util.List;
import java.util.ArrayList;

public class GradesUtil extends ArrayList<Grade>{
    private List<Grade> grades = new ArrayList<Grade>();

    GradesUtil(){}

    GradesUtil(List<Grade> grades){
        super(grades);
        this.grades = grades;
    }
    public Integer getIndex(String name){
        for(int i = 0; i < grades.size();i++){
            if(grades.get(i).getName().equals(name)) return i;
        }
        return -1000;
    }
    public boolean exists(String name){
        return !notExist(name);
    }
    public boolean notExist(String name){
        return getIndex(name) == -1000;
    }
}
