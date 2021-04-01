package com.ifmo.jjd.lesson7.taskone;

import java.util.Objects;

public class School {
    private String name;
    private Director director;
    private Teacher[] teachers;
    private Pupil[] pupils;

    public School(String name, Director director, Teacher[] teachers, Pupil[] pupils) {
        setName(name);
        setDirector(director);
        setTeachers(teachers);
        setPupils(pupils);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = Objects.requireNonNull(name, "name в School ошибочно");
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = Objects.requireNonNull(director, "name в School ошибочно");
    }

    public Teacher[] getTeachers() {
        return teachers;
    }

    public void setTeachers(Teacher[] teachers) {
        this.teachers = Objects.requireNonNull(teachers, "name в School ошибочно");
    }

    public Pupil[] getPupils() {
        return pupils;
    }

    public void setPupils(Pupil[] pupils) {
        this.pupils = Objects.requireNonNull(pupils, "name в School ошибочно");
    }

    public void dayToSchool(int count){
        for (int i = 0; i < count; i++) {
            this.director.startEducation(this.teachers, this.pupils);
            System.out.println("--------------------------------");
        }
        this.director.endEducation();
    }
}
