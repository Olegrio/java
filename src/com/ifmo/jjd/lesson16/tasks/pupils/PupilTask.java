package com.ifmo.jjd.lesson16.tasks.pupils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class PupilTask {
    public static void main(String[] args) {

        ArrayList<Pupil> pupils = new ArrayList<>(Pupil.getPupils(20));
        //System.out.println(pupils);

        // Используя Stream API:

        // 1. Разделить учеников на две группы: мальчиков и девочек. Результат: Map<Pupil.Gender, ArrayList<Pupil>>

        Map<Pupil.Gender, ArrayList<Pupil>> pupilsByGender = pupils.stream().collect(Collectors.groupingBy(Pupil::getGender, Collectors.toCollection(ArrayList::new)));
        System.out.println(pupilsByGender);
        System.out.println("--------------------------");


        // 2. Найти средний возраст учеников
        int averageAgePupils = pupils.stream().mapToInt(x -> LocalDateTime.now().getYear() - x.getBirthYear()).sum() / pupils.size();
        double avgAge = pupils.stream().mapToInt(pupil -> LocalDate.now().getYear() - pupil.getBirth().getYear()).average().orElse(0);
        System.out.println(averageAgePupils);
        System.out.println("--------------------------");

        // 3. Найти самого младшего ученика
        Pupil minAgePupil = pupils.stream().max(Comparator.comparing(Pupil::getBirth)).orElse(Pupil.getPupil());
        System.out.println(minAgePupil);
        System.out.println("--------------------------");

        // 4. Найти самого взрослого ученика
        Pupil maxAgePupil = pupils.stream().min(Comparator.comparing(Pupil::getBirth)).orElse(Pupil.getPupil());
        System.out.println(maxAgePupil);
        System.out.println("--------------------------");

        // 5. Собрать учеников в группы по году рождения
        Map<Integer, ArrayList<Pupil>> groupByBirth = pupils.stream().collect(Collectors.groupingBy(Pupil::getBirthYear, Collectors.toCollection(ArrayList::new)));
        System.out.println(groupByBirth);
        System.out.println("--------------------------");


        // 6. Оставить учеников с неповторяющимися именами,
        // имена и дату рождения оставшихся вывести в консоль.
        // Например, [Иван, Александра, Ольга, Иван, Ольга] -> [Иван, Александра, Ольга]
        Map<String, LocalDate> uniquePupils = pupils.stream().collect(Collectors.toMap(Pupil::getName, Pupil::getBirth, (item1, item2) -> item1));
        System.out.println(uniquePupils);
        System.out.println("--------------------------");

        // 7. Отсортировать по полу, потом по дате рождения, потом по имени (в обратном порядке), собрать в список (List)
        ArrayList<Pupil> pupilsSorted = pupils.stream()
                .sorted(Comparator.comparing(Pupil::getGender)
                        .thenComparing(Pupil::getBirth)
                        .thenComparing(Comparator.comparing(Pupil::getName).reversed())
                ).collect(Collectors.toCollection(ArrayList::new));

        System.out.println(pupilsSorted);
        System.out.println("--------------------------");


        // 8. Вывести в консоль всех учеников в возрасте от N до M лет
        int N = 17;
        int M = 20;
        List<Pupil> filteredForAge = pupils.stream().filter(n -> n.getAge() > N && n.getAge() < M).collect(Collectors.toList());
        System.out.println(filteredForAge);
        System.out.println("--------------------------");


        // 9. Собрать в список всех учеников с именем=someName
        String someName = "ИВан";
        List<Pupil> filteredForName = pupils.stream().filter(n -> n.getName().equalsIgnoreCase(someName)).collect(Collectors.toList());
        System.out.println(filteredForName);
        System.out.println("--------------------------");


        // 10. Собрать Map<Pupil.Gender, Integer>, где Pupil.Gender - пол, Integer - суммарный возраст учеников данного пола
        Map<Pupil.Gender, Integer> genderIntegerMap = pupils.stream().collect(Collectors.toMap(Pupil::getGender, Pupil::getAge, (Integer::sum)));
        System.out.println(genderIntegerMap);
    }
}