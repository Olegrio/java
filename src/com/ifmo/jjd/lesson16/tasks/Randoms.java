package com.ifmo.jjd.lesson16.tasks;

public class Randoms {

    // если у методов с одинаковым названием отличаются аргументы - это перегруженные методы
    public static int getRandomInt(int min, int max){
        return (int) ((Math.random() * (max -min)) + min);
    }

    public static int getRandomInt(int max){
        return (int)(Math.random() * max);
    }
}
