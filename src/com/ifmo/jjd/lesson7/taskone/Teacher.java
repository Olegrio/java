package com.ifmo.jjd.lesson7.taskone;

import java.util.Objects;

public class Teacher extends Person implements Learn {
    private String discipline;
    private final int teacherLevel = 1;

    public Teacher(String name, int age, String discipline) {
        super(name, age);
        this.discipline = discipline;
    }

    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = Objects.requireNonNull(discipline, "discipline в Teacher ошибочно");
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "discipline='" + discipline + '\'' +
                ", teacherLevel=" + teacherLevel +
                '}';
    }

    @Override
    public void learn(Pupil[] pupils) {
        for (Pupil pupil : pupils) {
            System.out.println(pupil.toString());
            pupil.toStudy(teacherLevel);
        }
    }
}
