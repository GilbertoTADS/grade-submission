package com.dev.gradesubmission.service;

import com.dev.gradesubmission.Grade;
import com.dev.gradesubmission.repository.GradeRepository;

public class GradeService {
    private GradeRepository gradeRepo = new GradeRepository();

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
}
