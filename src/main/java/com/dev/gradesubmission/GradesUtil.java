package com.dev.gradesubmission;

import java.util.List;
import java.util.ArrayList;

public class GradesUtil extends ArrayList<Grade>{
    Grade auxGrade = new Grade();

    public GradesUtil(){}

    GradesUtil(List<Grade> grades){
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
        System.out.println("my index: "+getIndex(id));
        return getIndex(id) == Constants.NOT_FOUND;
    }
}
