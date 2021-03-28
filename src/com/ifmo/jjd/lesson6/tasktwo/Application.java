package com.ifmo.jjd.lesson6.tasktwo;

public class Application {
    public static void main(String[] args) {
    /*   2. Реализовать объектную модель:
        Кот: имя, цвет, скорость, вес, пойманные мыши;
        Мышь: скорость.
                Кот хранит информацию о пойманных мышах (максимум 100).
                Кот ловит мышь, только, если его скорость выше, чем у мыши.
        Кот может напасть на другого кота и, если он больше противника (по весу),
                то может отобрать его мышей (если скорость мыши выше, чем скорость кота, она убежит),
        массив с мышами противника нужно обнулить (всем элементам присвоить значение null).*/

        Mouse mouse1 = new Mouse(10);
        Mouse mouse2 = new Mouse(9);
        Mouse mouse3 = new Mouse(11);
        Mouse mouse4 = new Mouse(12);
        Mouse mouse5 = new Mouse(13);
        Mouse mouse6 = new Mouse(8);
        Mouse mouse7 = new Mouse(9);
        Mouse mouse8 = new Mouse(9);

        Cat cat1 = new Cat("Кот1", "серый", 12, 6);
        Cat cat2 = new Cat("Кот2", "белый", 13, 7);
        Cat cat3 = new Cat("Кот3", "черный", 14, 5);
        Cat cat4 = new Cat("Кот4", "рыжий", 11, 8);

        cat1.addLiveMouse(mouse1);
        cat1.addLiveMouse(mouse2);
        cat1.addLiveMouse(mouse3);
        cat1.addLiveMouse(mouse4);
        cat1.addLiveMouse(mouse5);
        cat1.addLiveMouse(mouse6);
        cat1.addLiveMouse(mouse7);
        cat1.addLiveMouse(mouse8);
        cat1.addLiveMouse(mouse1);
        cat1.addLiveMouse(mouse2);
        cat1.addLiveMouse(mouse3);

        cat2.attackCat(cat1);


        System.out.println("cat1: " + cat1.toString());
        System.out.println("cat2: " + cat2.toString());


    }
}
