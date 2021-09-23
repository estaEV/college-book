package com.estafet.learning.sprint7;

import java.util.LinkedHashMap;
import java.util.Map;

public class GradeBook {
    private int StudentId;
    private int numOfSubjectsStudied;
    private Map<String, Integer> grades = new LinkedHashMap<>();

    public int getStudentId() {
        return StudentId;
    }

    public void setStudentId(int studentId) {
        StudentId = studentId;
    }

    public int getNumOfSubjectsStudied() {
        return numOfSubjectsStudied;
    }

    public void setNumOfSubjectsStudied(int numOfSubjectsStudied) {
        this.numOfSubjectsStudied = numOfSubjectsStudied;
    }

    public Map<String, Integer> getGrades() {
        return grades;
    }

    public void setGrades(Map<String, Integer> grades) {
        this.grades = grades;
    }
}
