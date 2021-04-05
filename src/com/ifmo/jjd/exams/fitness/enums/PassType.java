package com.ifmo.jjd.exams.fitness.enums;

public enum PassType {
    DAY("Дневной абонемент"),
    MONTHLY("Месячный абонемент"),
    FULL("Полный абонемент");

    private String name;

    PassType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

