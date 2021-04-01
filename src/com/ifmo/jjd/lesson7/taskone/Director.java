package com.ifmo.jjd.lesson7.taskone;

import java.util.Arrays;

public class Director extends Person {
    private boolean isLearn = false;

    public Director(String name, int age) {
        super(name, age);
    }

    public void startEducation(Teacher[] teachers, Pupil[] pupils){
        if(!isLearn) {
            System.out.println("Начало учебного дня");
            System.out.println("------------------------------");
        }
        isLearn = true;
        int count;
        for (Teacher teacher : teachers) {
             count = 0;
            for (Pupil pupil : pupils) {
                if (pupil.getDiscipline().equals(teacher.getDiscipline())) {
                    count++;
                }
            }
            Pupil[] pupilsArr = new Pupil[count];
            int indexPaste = 0;
            for (Pupil pupil : pupils) {
                if (pupil.getDiscipline().equals(teacher.getDiscipline())) {
                    pupilsArr[indexPaste] = pupil;
                    indexPaste++;
                }
            }
            teacher.learn(pupilsArr);
        }


    }

    public void endEducation(){
        System.out.println("Конец учебного дня");
        isLearn = false;
    }
}
