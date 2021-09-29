package com.estafet.learning.sprint7;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;

public class RandomGenerator {
    private List<Student> stdList = null;
    private List<Subject> subList = null;
    private List<GradeBook> graList = null;
    private int subStartId = 55554;
    private int stdStartId = 19999;

    public List<Student> getStdList() {
        return stdList;
    }

    public void setStdList(List<Student> stdList) {
        this.stdList = stdList;
    }

    public List<Subject> getSubList() {
        return subList;
    }

    public void setSubList(List<Subject> subList) {
        this.subList = subList;
    }

    public List<GradeBook> getGraList() {
        return graList;
    }

    public void setGraList(List<GradeBook> graList) {
        this.graList = graList;
    }

    public void generateMeSome() {

        int length = Globals.STUDENTNAMES.length;
        Supplier<Integer> numOfSubjects = () -> ThreadLocalRandom.current().nextInt(6, 9);
        Supplier<Integer> dice = () -> ThreadLocalRandom.current().nextInt(1, 60);
        Supplier<Integer> year = () -> ThreadLocalRandom.current().nextInt(2018, 2022);
        Supplier<Integer> grade = () -> ThreadLocalRandom.current().nextInt(2, 6);

        stdList = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            Student fok = new Student();
            stdList.add(fok);
            stdList.get(i).setName(Globals.STUDENTNAMES[i]);
            stdStartId = ++stdStartId;
            stdList.get(i).setStudentId(stdStartId);
            stdList.get(i).setClassYear(year.get());
            //System.out.println(stdList.get(i));
        }

        subList = new ArrayList<>();
        for (int i = 0; i < Globals.SUBJECTS.length; i++) {
            Subject fuk = new Subject();
            subList.add(fuk);
            subList.get(i).setSubjectName(Globals.SUBJECTS[i]);
            subStartId = ++subStartId;
            subList.get(i).setSubjectId(subStartId);
            subList.get(i).setYearStudied(year.get());
        }

        graList = new ArrayList<>();
        for (int i = 0; i < Globals.STUDENTNAMES.length; i++) {
            int numOfSubjectsStudied = numOfSubjects.get();
            GradeBook fak = new GradeBook();
            graList.add(fak);
            graList.get(i).setStudentId(stdList.get(i).getStudentId());

            Map<String, Integer> grades = new LinkedHashMap<>();
            for (int j = 0; j < numOfSubjectsStudied; j++) {
                graList.get(i).setNumOfSubjectsStudied(numOfSubjectsStudied);
                grades.put(String.valueOf(subList.get(dice.get()).getSubjectId()), grade.get());
            }
            graList.get(i).setGrades(grades);
        }
    }
}
