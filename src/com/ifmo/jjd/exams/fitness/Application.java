package com.ifmo.jjd.exams.fitness;

import com.ifmo.jjd.exams.fitness.enums.HallZone;
import com.ifmo.jjd.exams.fitness.enums.PassType;

public class Application {
    public static void main(String[] args) {

        Visitor visitor1 = new Visitor("Иван", "Иванов", "1990");
        Visitor visitor2 = new Visitor("Петр", "Александров", "2000");
        Visitor visitor3 = new Visitor("Сергей", "Степанов", "2001");
        Visitor visitor4 = new Visitor("Марина", "Смирнова", "1991");
        Visitor visitor5 = new Visitor("Александра", "Федорова", "2002");
        Visitor visitor6 = new Visitor("Анастасия", "Круглова", "1987");

        Fitness fitnessHall = new Fitness();


        Pass pass1 = new Pass(PassType.DAY, visitor1);
        Pass pass2 = new Pass(PassType.DAY, visitor2);
        Pass pass3 = new Pass(PassType.MONTHLY, visitor3);
        Pass pass4 = new Pass(PassType.MONTHLY, visitor4);
        Pass pass5 = new Pass(PassType.FULL, visitor5);
        Pass pass6 = new Pass(PassType.FULL, visitor6);


        System.out.println(fitnessHall.visit(pass1, HallZone.GYM));
    }
}
