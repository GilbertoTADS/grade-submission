package com.dev.gradesubmission;

import java.util.UUID;

public class Grade {
    private String id;
    private String subject;
    private String name;
    private String score;

    Grade(){
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
}
