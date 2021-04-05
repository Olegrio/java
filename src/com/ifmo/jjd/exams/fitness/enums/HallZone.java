package com.ifmo.jjd.exams.fitness.enums;

public enum HallZone {
    GYM("тренажерный зал"),
    POOL("бассейн"),
    GROUP("групповые занятия");

    private String name;

    HallZone(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
