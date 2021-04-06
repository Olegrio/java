package com.ifmo.jjd.exams.fitness;

import com.ifmo.jjd.exams.fitness.enums.HallZone;
import com.ifmo.jjd.exams.fitness.settings.Answers;
import com.ifmo.jjd.exams.fitness.settings.Settings;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

import static com.ifmo.jjd.exams.fitness.enums.HallZone.*;

public class Fitness {
    private int maxCountHall = Settings.MAX_COUNT_HALL;

    private Pass[] gymPass = new Pass[maxCountHall];
    private Pass[] poolPass = new Pass[maxCountHall];
    private Pass[] groupPass = new Pass[maxCountHall];

    private int countGym = 0;
    private int countPool = 0;
    private int countGroup = 0;

    /**
     * Посещение спортзала
     * @param pass абонемент
     * @param zone зона посещения
     */
    public void visit(Pass pass, HallZone zone){
        String response;
        switch (zone){
            case GYM:
                if(countGym >= maxCountHall){
                    System.out.println(GYM.getName() + " - " + Answers.HALL_COMPLETE);
                    break;
                }
                response = checkPassType(pass, GYM);
                if (response.equals(Answers.APPROVED)) {
                    addPassToZone(pass, gymPass);
                    countGym++;
                    System.out.println(getSmallInfo(pass, GYM));
                }
                System.out.println(response);
                break;
            case POOL:
                if(countPool >= maxCountHall){
                    System.out.println(POOL.getName() + " - " + Answers.HALL_COMPLETE);
                    break;
                }
                response = checkPassType(pass, POOL);
                if (response.equals(Answers.APPROVED)) {
                    addPassToZone(pass, poolPass);
                    countPool++;
                    System.out.println(getSmallInfo(pass, POOL));
                }
                System.out.println(response);
                break;
            case GROUP:
                if(countGroup >= maxCountHall){
                    System.out.println(GROUP.getName() + " - " + Answers.HALL_COMPLETE);
                    break;
                }
                response = checkPassType(pass, GROUP);
                if (response.equals(Answers.APPROVED)) {
                    addPassToZone(pass, groupPass);
                    countGroup++;
                    System.out.println(getSmallInfo(pass, GROUP));
                    System.out.println(Answers.APPROVED);
                    break;
                }
                System.out.println(response);
                break;
            default:
                System.out.println(Answers.NOT_APPROVED);
        }
    }

    /**
     * Закрытие фитнеса
     */
    public void closeFitness(){
        gymPass = new Pass[maxCountHall];
        poolPass = new Pass[maxCountHall];
        groupPass = new Pass[maxCountHall];

        int countGym, countPool, countGroup = 0;
    }

    /**
     * Добавление абонемена в массив содержащий посетителей зоны
     * @param pass абонемент
     * @param group массив с текущими посетителями зоны
     */
    private void addPassToZone(Pass pass, Pass[] group){
        for (int i = 0; i < group.length; i++) {
            if(Objects.isNull(group[i])){
                group[i] = pass;
                return;
            }
        }
    }

    /**
     * Проверка типа абонемента с дальнейшей передачей в метод checkPass для проверки возможности посещения по данному абонементу той или иной зоны
     * @param pass абонемент
     * @param zone зона посещения
     * @return возвращает строку Settings.Answers c причиной отказа или возможностью пройти
     */
    private String checkPassType(Pass pass, HallZone zone){
        if(pass.getEndDate().isBefore(LocalDateTime.now())){
            return  Answers.PASS_ENDED;
        }

        int[] gymHours;
        int[] poolHours;
        int[] groupHours;

        switch (pass.getType()) {
            case DAY -> {
                gymHours = new int[]{Settings.DAY_PASS_GYM_START_HOUR, Settings.DAY_PASS_GYM_END_HOUR};
                poolHours =  new int[]{Settings.DAY_PASS_POOL_START_HOUR, Settings.DAY_PASS_POOL_END_HOUR};
                groupHours =  new int[]{Settings.DAY_PASS_GROUP_START_HOUR, Settings.DAY_PASS_GROUP_END_HOUR};
                return checkPass(zone, pass, gymHours, poolHours, groupHours);
            }
            case MONTHLY -> {
                gymHours = new int[]{Settings.MONTHLY_PASS_GYM_START_HOUR, Settings.MONTHLY_PASS_GYM_END_HOUR};
                poolHours =  new int[]{Settings.MONTHLY_PASS_POOL_START_HOUR, Settings.MONTHLY_PASS_POOL_END_HOUR};
                groupHours =  new int[]{Settings.MONTHLY_PASS_GROUP_START_HOUR, Settings.MONTHLY_PASS_GROUP_END_HOUR};
                return checkPass(zone, pass, gymHours, poolHours, groupHours);
            }
            case FULL -> {
                gymHours = new int[]{Settings.FULL_PASS_GYM_START_HOUR, Settings.FULL_PASS_GYM_END_HOUR};
                poolHours =  new int[]{Settings.FULL_PASS_POOL_START_HOUR, Settings.FULL_PASS_POOL_END_HOUR};
                groupHours =  new int[]{Settings.FULL_PASS_GROUP_START_HOUR, Settings.FULL_PASS_GROUP_END_HOUR};
                return checkPass(zone, pass, gymHours, poolHours, groupHours);
            }
            default -> {
                return Answers.NOT_APPROVED;
            }
        }
    }

    /**
     * Проверка возможности посещения по данному абонементу той или иной зоны
     * @param zone зона посещения
     * @param pass абонемент
     * @param gymHours доступные по абонементу из Settings.Settings часы посещения тренажерного зала
     * @param poolHours доступные по абонементу из Settings.Settings часы посещения бассейна
     * @param groupHours доступные по абонементу из Settings.Settings часы посещения групповых занятий
     * @return возвращает строку Settings.Answers c причиной отказа или возможностью пройти
     */
    private String checkPass(HallZone zone, Pass pass, int[] gymHours, int[] poolHours, int[] groupHours){
        int currentHour = LocalDateTime.now().getHour();
        if(checkPassZones(pass)) {
            return Answers.PASS_ALREADY_EXISTS;
        }
        switch (zone) {
            case GYM -> {
                if (gymHours[0] < 0 || gymHours[1] < 0){
                    return Answers.NOT_INCLUDED_PASS;
                }
                if(currentHour < gymHours[0] || currentHour > gymHours[1]) {
                    return Answers.HALL_CLOSED + " - " + zone.getName();
                }

                return Answers.APPROVED;
            }
            case POOL -> {
                if (poolHours[0] < 0 || poolHours[1] < 0){
                    return Answers.NOT_INCLUDED_PASS;
                }
                if(currentHour < poolHours[0] || currentHour > poolHours[1]) {
                    return Answers.HALL_CLOSED + " - " + zone.getName();
                }
                return Answers.APPROVED;
            }

            case GROUP -> {
                if (groupHours[0] < 0 || groupHours[1] < 0){
                    return Answers.NOT_INCLUDED_PASS;
                }
                if(currentHour < groupHours[0] || currentHour > groupHours[1]) {
                    return Answers.HALL_CLOSED + " - " + zone.getName();
                }
                return Answers.APPROVED;
            }
            default -> {
                return Answers.NOT_APPROVED;
            }
        }
    }


    /**
     * проверка на наличие регистрации абонемента в других зонах
     * @param pass абонемент
     * @return true - зарегестрирован в тругих зонах. false - нет
     */
    private boolean checkPassZones(Pass pass){
        for (Pass item : gymPass) {
            if(item != null && item.getUuid().equals(pass.getUuid())){
                return true;
            }
        }
        for (Pass item : poolPass) {
            if(item != null && item.getUuid().equals(pass.getUuid())){
                return true;
            }
        }
        for (Pass item : groupPass) {
            if(item != null && item.getUuid().equals(pass.getUuid())){
                return true;
            }
        }
        return false;
    }

    /**
     * Покинуть зону занятий, ищет и удаляет абонемент из массива занимающихся в зоне
     * @param pass абонемент
     */
    public void leaveTheHallZone(Pass pass){
        for (int i = 0; i < gymPass.length; i++) {
            if(gymPass[i] != null && gymPass[i].getUuid().equals(pass.getUuid())){
                gymPass[i] = null;
            }
        }
        for (int i = 0; i < poolPass.length; i++) {
            if(poolPass[i] != null && poolPass[i].getUuid().equals(pass.getUuid())){
                poolPass[i] = null;
            }
        }
        for (int i = 0; i < groupPass.length; i++) {
            if(groupPass[i] != null && groupPass[i].getUuid().equals(pass.getUuid())){
                groupPass[i] = null;
            }
        }
    }

    /**
     * Формирование строки с краткой информацией по посещению
     * @param pass абонемент
     * @param zone зона посещения
     * @return
     */
    public String getSmallInfo(Pass pass,HallZone zone){
        return "Фамилия: " + pass.getOwner().getSurname() + ", Имя: " + pass.getOwner().getName() + "\n" +
                "Посетил: " + zone.getName() + "\n" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd MMMM yyyy в HH:mm"));

    }

}
