package com.ifmo.jjd.exams.game;

import com.ifmo.jjd.exams.game.enums.MenuItems;

import java.util.ArrayList;
import java.util.Arrays;

public class Menu {

    private ArrayList<MenuItems> items = new ArrayList<>();

    public Menu(Boolean isShowDownload) {
        Arrays.asList(MenuItems.values()).forEach(item -> {
            if(!isShowDownload && item == MenuItems.LOAD){
                return;
            }
            this.items.add(item);
        });
    }
    /**
     * Получения типа действия MenuItems по числу
     * @param numberAction
     * @return MenuItems
     */
    public MenuItems getAction(int numberAction){
        MenuItems actions = null;
        for (MenuItems item : items) {
            if (item.getNumberAction() == numberAction) {
                actions = item;
                break;
            }
        }
        return actions;
    }

    /**
     * Вывод меню
     */
    public void renderMenu(){
        System.out.println("----------------Меню----------------");
        items.forEach(item ->{
            System.out.println(item.getName() + " - для выбора нажмите " + item.getNumberAction());
        });
    }
}
