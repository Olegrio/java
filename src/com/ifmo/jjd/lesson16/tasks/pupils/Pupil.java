package com.ifmo.jjd.lesson16.tasks.pupils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import com.ifmo.jjd.lesson16.tasks.Randoms;

public class Pupil {
    enum Gender {
        MALE, FEMALE
    }
    private UUID number; // уникальное значение для каждого ученика
    private String name;
    private Gender gender;
    private LocalDate birth;

    public Pupil(UUID number, String name, Gender gender, LocalDate birth) {
        this.number = number;
        this.name = name;
        this.gender = gender;
        this.birth = birth;
    }
// TODO: добавить все необходимые методы


    public UUID getNumber() {
        return number;
    }

    public void setNumber(UUID number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getBirthYear() {
        return birth.getYear();
    }

    public int getAge() {
        return LocalDateTime.now().getYear() - getBirthYear();
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    public static Pupil getPupil() {
        String[] namesMale = {"Иван", "Петр", "Сергей"};
        String[] namesFemale = {"Ольга","Мария"};
        Gender gender = Gender.values()[Randoms.getRandomInt(2)];
        String name;
        if (gender == Gender.FEMALE){
            name = namesFemale[Randoms.getRandomInt(0, namesFemale.length  )];
        } else {
            name = namesMale[Randoms.getRandomInt(0, namesMale.length )];
        }
        return new Pupil(
                UUID.randomUUID(),
                name,
                gender,
                LocalDate.of(Randoms.getRandomInt(1998, 2004), Randoms.getRandomInt(1, 12), Randoms.getRandomInt(1, 28))
                );
    }

    public static List<Pupil> getPupils(int count) {
        ArrayList<Pupil> pupils = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            pupils.add(getPupil());
        }
        return pupils;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pupil)) return false;
        Pupil pupil = (Pupil) o;
        return Objects.equals(number, pupil.number) &&
                Objects.equals(name, pupil.name) &&
                gender == pupil.gender &&
                Objects.equals(birth, pupil.birth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, name, gender, birth);
    }

    @Override
    public String toString() {
        return "\nPupil{" +
                "number=" + number +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", birth=" + birth +
                '}';
    }
}