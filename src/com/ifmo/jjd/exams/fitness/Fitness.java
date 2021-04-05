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

    public String visit(Pass pass, HallZone zone){
        String response;
        switch (zone){
            case GYM:
                if(countGym >= maxCountHall){
                    return GYM.getName() + " - " + Answers.HALL_COMPLETE;
                }
                response = checkPassType(pass, GYM);
                if (response.equals(Answers.APPROVED)) {
                    addPassToZone(pass, gymPass);
                    countGym++;
                    System.out.println(getSmallInfo(pass, GYM));
                }
                return response;
            case POOL:
                if(countPool >= maxCountHall){
                    return POOL.getName() + " - " + Answers.HALL_COMPLETE;
                }
                response = checkPassType(pass, POOL);
                if (response.equals(Answers.APPROVED)) {
                    addPassToZone(pass, poolPass);
                    countPool++;
                    System.out.println(getSmallInfo(pass, POOL));
                }
                return response;
            case GROUP:
                if(countGroup >= maxCountHall){
                    return GROUP.getName() + " - " + Answers.HALL_COMPLETE;
                }
                response = checkPassType(pass, GROUP);
                if (response.equals(Answers.APPROVED)) {
                    addPassToZone(pass, groupPass);
                    countGroup++;
                    System.out.println(getSmallInfo(pass, GROUP));
                    return Answers.APPROVED;
                }
                return response;
            default: return Answers.NOT_APPROVED;
        }
    }

    public void closeFitness(){
        gymPass = new Pass[maxCountHall];
        poolPass = new Pass[maxCountHall];
        groupPass = new Pass[maxCountHall];

        int countGym, countPool, countGroup = 0;
    }

    private void addPassToZone(Pass pass, Pass[] group){
        for (int i = 0; i < group.length; i++) {
            if(Objects.isNull(group[i])){
                group[i] = pass;
                return;
            }
        }
    }

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

    private String checkPass(HallZone zone, Pass pass, int[] gymHours, int[] poolHours, int[] groupHours){
        int currentHour = LocalDateTime.now().getHour();
        if(!checkPassZones(pass)) {
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

    private boolean checkPassZones(Pass pass){
        for (Pass item : gymPass) {
            if(item != null && item.getUuid().equals(pass.getUuid())){
                return false;
            }
        }
        for (Pass item : poolPass) {
            if(item != null && item.getUuid().equals(pass.getUuid())){
                return false;
            }
        }
        for (Pass item : groupPass) {
            if(item != null && item.getUuid().equals(pass.getUuid())){
                return false;
            }
        }
        return true;
    }

    public String getSmallInfo(Pass pass,HallZone zone){
        return "Фамилия: " + pass.getOwner().getSurname() + ", Имя: " + pass.getOwner().getName() + "\n" +
                "Посетил: " + zone.getName() + "\n" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd MMMM yyyy в hh:mm"));

    }

}
