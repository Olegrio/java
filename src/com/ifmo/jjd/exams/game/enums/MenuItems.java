package com.ifmo.jjd.exams.game.enums;

public enum MenuItems {
    START("Начать игру",0),
    RETURN("Продолжить игру",1),
    SAVE("Сохранить игру",2),
    LOG_OUT("Выйти",3),
    LOAD("Загрузить игру",4);


    private final String name;
    private final int numberAction;

    MenuItems(String name, int number) {
        this.name = name;
        this.numberAction = number;
    }

    public int getNumberAction() {
        return numberAction;
    }

    public String getName() {
        return name;
    }

}
