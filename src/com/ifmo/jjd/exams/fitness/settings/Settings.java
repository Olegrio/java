package com.ifmo.jjd.exams.fitness.settings;

public class Settings {
    public final static int MINIMUM_AGE = 14; // минимальный возраст для владельца абонемента
    public final static int MAX_COUNT_HALL = 20; // максимальное число занимающихся в зоне одновременно

    // время прохода в зоны занятий для абонементов,
    // -1 нет возможности посетить зону для данного типа абонемента
    public final static int DAY_PASS_GYM_START_HOUR = 8;
    public final static int DAY_PASS_GYM_END_HOUR = 22;
    public final static int DAY_PASS_POOL_START_HOUR = 8;
    public final static int DAY_PASS_POOL_END_HOUR = 22;
    public final static int DAY_PASS_GROUP_START_HOUR = -1;
    public final static int DAY_PASS_GROUP_END_HOUR = -1;

    public final static int MONTHLY_PASS_GYM_START_HOUR = 8;
    public final static int MONTHLY_PASS_GYM_END_HOUR = 16;
    public final static int MONTHLY_PASS_POOL_START_HOUR = -1;
    public final static int MONTHLY_PASS_POOL_END_HOUR = -1;
    public final static int MONTHLY_PASS_GROUP_START_HOUR = 8;
    public final static int MONTHLY_PASS_GROUP_END_HOUR = 16;

    public final static int FULL_PASS_GYM_START_HOUR = 8;
    public final static int FULL_PASS_GYM_END_HOUR = 22;
    public final static int FULL_PASS_POOL_START_HOUR = 8;
    public final static int FULL_PASS_POOL_END_HOUR = 22;
    public final static int FULL_PASS_GROUP_START_HOUR = 8;
    public final static int FULL_PASS_GROUP_END_HOUR = 22;

}
