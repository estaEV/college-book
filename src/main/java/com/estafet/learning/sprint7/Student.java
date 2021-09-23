package com.estafet.learning.sprint7;

import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;

public class Student {
    private String name;
    private int StudentId;
    private int classYear;


    public int getStudentId() {
        return StudentId;
    }

    public void setStudentId(int studentId) {
        StudentId = studentId;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getClassYear() {
        return classYear;
    }

    public void setClassYear(int classYear) {
        this.classYear = classYear;
    }

}
