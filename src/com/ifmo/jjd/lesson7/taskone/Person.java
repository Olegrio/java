package com.ifmo.jjd.lesson7.taskone;

import java.util.Objects;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        setName(name);
        setAge(age);
    }

    private void setName(String name) {
        this.name = Objects.requireNonNull(name, "name в Person ошибочно");
    }

    private void setAge(int age) {
        if(age < 0) throw new IllegalArgumentException("age < 5");
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
