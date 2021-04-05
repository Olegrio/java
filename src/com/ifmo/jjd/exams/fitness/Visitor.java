package com.ifmo.jjd.exams.fitness;

import com.ifmo.jjd.exams.fitness.settings.Settings;

import java.time.LocalDateTime;
import java.util.Objects;

public class Visitor {

    private String name;
    private String surname;
    private String yearOfBirth;

    public Visitor(String name, String surname, String yearOfBirth) {
        setName(name);
        setSurname(surname);
        setYearOfBirth(yearOfBirth);
    }

    public void setYearOfBirth(String yearOfBirth) {
        if(Objects.isNull(yearOfBirth)) throw new IllegalArgumentException("yearOfBirth = null");
        int nowDate = LocalDateTime.now().getYear();
        if(nowDate - Integer.parseInt(yearOfBirth) < Settings.MINIMUM_AGE){
            throw new IllegalArgumentException(
                    "Возраст владельца покупателя "
                            .concat(name)
                            .concat(" ")
                            .concat(surname)
                            .concat(" меньше ")
                            .concat(Objects.toString(Settings.MINIMUM_AGE))
                            .concat(" лет"));
        }
        this.yearOfBirth =  Objects.requireNonNull(yearOfBirth, "yearOfBirth -> Visitor null");

    }

    public void setName(String name) {
        this.name = Objects.requireNonNull(name, "name -> Visitor null");
    }

    public void setSurname(String surname) {
        this.surname = Objects.requireNonNull(surname, "surname -> Visitor null");
    }


    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getYearOfBirth() {
        return yearOfBirth;
    }

    @Override
    public String toString() {
        return "Visitor{" +
                "Имя: '" + name + '\'' +
                ", Фамилия: '" + surname + '\'' +
                ", Год рождения: '" + yearOfBirth + '\'' +
                '}';
    }
}
