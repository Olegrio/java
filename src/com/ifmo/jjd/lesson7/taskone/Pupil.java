package com.ifmo.jjd.lesson7.taskone;

import java.util.Objects;

public class Pupil extends Person implements ToStudy {
    private String discipline;
    private int knowledgeLevel;

    public Pupil(String name, int age, String discipline, int knowledgeLevel) {
        super(name, age);
        setDiscipline(discipline);
        setKnowledgeLevel(knowledgeLevel);
    }

    private void setDiscipline(String discipline) {
        this.discipline = Objects.requireNonNull(discipline, "discipline в Pupil ошибочно");
    }

    private void setKnowledgeLevel(int knowledgeLevel) {
        if(knowledgeLevel < 0) throw new IllegalArgumentException("knowledgeLevel < 0");
        this.knowledgeLevel = knowledgeLevel;
    }

    public String getDiscipline() {
        return discipline;
    }

    public int getKnowledgeLevel() {
        return knowledgeLevel;
    }

    @Override
    public String toString() {
        return "Pupil{" +
                "discipline='" + discipline + '\'' +
                ", knowledgeLevel=" + knowledgeLevel +
                ", name=" + getName() +
                ", age=" + getAge() +
                '}';
    }

    @Override
    public void toStudy(int amount){
        setKnowledgeLevel(knowledgeLevel + amount);
    }

}
