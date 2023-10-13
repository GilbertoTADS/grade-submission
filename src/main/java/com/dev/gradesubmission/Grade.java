package com.dev.gradesubmission;

import java.util.UUID;

import javax.validation.constraints.NotBlank;

public class Grade implements Cloneable{
    private String id;
    @NotBlank(message = "Subject cannot be blank")
    private String subject;
    @NotBlank(message = "Name cannot be blank")
    private String name;
    @Score(message = "Score must be a letter grade")
    private String score;

    public Grade(){
        this.id = UUID.randomUUID().toString();
    }
    public void setId(String id){
        this.id = id;
    }
    public String getId() {
        return id;
    }
    public String getScore() {
        return score;
    }
    public void setScore(String score) {
        this.score = score;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }
    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        Grade g = (Grade)o;
        String id = this.getId();
        return id.equals(g.getId());
    }
    @Override
    public Grade clone() throws CloneNotSupportedException{
        Grade grade = (Grade) super.clone();
        grade.setName(this.name);
        grade.setScore(this.score);
        grade.setSubject(this.subject);
        return grade;
    }
}
