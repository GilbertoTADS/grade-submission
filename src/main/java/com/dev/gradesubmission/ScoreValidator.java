package com.dev.gradesubmission;

import java.util.HashMap;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ScoreValidator  implements ConstraintValidator<Score, String>{
    HashMap<String,Integer> score = new HashMap<>();
    
    ScoreValidator(){
        this.score.put("A+",1);
        this.score.put("A",1);
        this.score.put("A-",3);
        this.score.put("B+",4);
        this.score.put("B",5);
        this.score.put("B-",6);
        this.score.put("C+",7);
        this.score.put("C",8);
        this.score.put("C-",9);
        this.score.put("D+",10);
        this.score.put("D",11);
        this.score.put("D-",12);
        this.score.put("E+",13);
        this.score.put("E",14);
        this.score.put("E-",15);
        this.score.put("F",16);

    }
        

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return this.score.get(value) != null;
    }
    
}
