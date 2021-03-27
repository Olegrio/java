package com.ifmo.jjd.lesson6.taskone;

import java.util.Objects;

public class Author {
    private String name;
    private String surname;

    public Author(String name, String surname) {
        setName(name);
        setSurname(surname);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = Objects.requireNonNull(name, "name в Author ошибочно");
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = Objects.requireNonNull(surname, "surname в Author ошибочно");
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
