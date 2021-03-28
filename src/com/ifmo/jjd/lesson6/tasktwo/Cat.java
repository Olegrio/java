package com.ifmo.jjd.lesson6.tasktwo;

import java.util.Arrays;
import java.util.Objects;

public class Cat {

    // Кот: имя, цвет, скорость, вес, пойманные мыши;
    private String name;
    private String color;
    private int speed;
    private int weight;
    private final Mouse[] capturedMouse = new Mouse[100];

    public Cat(String name, String color, int speed, int weight) {
        setName(name);
        setColor(color);
        setSpeed(speed);
        setWeight(weight);
    }

    public void addLiveMouse(Mouse mouse){
        if(mouse == null) throw new IllegalArgumentException("Cat -> -> addMouse -> mouse == null");
        for (int i = 0; i < capturedMouse.length; i++) {
            if(capturedMouse[i] == null) {
                if(mouse.getSpeed() < this.speed){
                    capturedMouse[i] = mouse;
                    mouse.setSpeed(0);
                    System.out.println("Кот ".concat(this.name).concat(" поймал мышь"));
                } else {
                    System.out.println("Кот не догнал мышь");
                }
                return;
            }
        }
        System.out.println("Кот сыт");
    }

    private void addDeadMouse(Mouse mouse){
        for (int i = 0; i < capturedMouse.length; i++) {
            if(capturedMouse[i] == null) {
                capturedMouse[i] = mouse;
                return;
            }
        }
        System.out.println("Кот сыт");
    }

    public void attackCat(Cat cat){
        if(cat.getWeight() < this.weight){
            pickUpMice(cat.giveMice());
            System.out.println("кот: ".concat(this.name).concat(" отобрал мышей у кота: ").concat(cat.getName()));
            return;
        }
        System.out.println("Атакуемый кот оказался больше");
    }

    public Mouse[] giveMice(){
        Mouse[] mouseValue = this.capturedMouse.clone();
        Arrays.fill(this.capturedMouse, null);
        return mouseValue;
    }

    private void pickUpMice(Mouse[] mouse){
        for (Mouse item : mouse) {
            if (item != null) {
                addDeadMouse(item);
            }
        }
    }

    public String getName(){
        return name;
    }

    public int getWeight(){
        return weight;
    }

    public Mouse[] getCapturedMouse() {
        return capturedMouse;
    }

    private void setName(String name) {
        this.name = Objects.requireNonNull(name, "Cat -> name == null");
    }

    private void setColor(String color) {
        this.color = Objects.requireNonNull(name, "Cat -> color == null");
    }

    private void setSpeed(int speed) {
        if(speed == 0) throw new IllegalArgumentException("Cat -> speed <= 0 ");
        this.speed = speed;
    }

    private void setWeight(int weight) {
        if(weight <= 0) throw new IllegalArgumentException("Cat -> weight <= 0 ");
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", speed=" + speed +
                ", weight=" + weight +
                ", \ncapturedMouse=" + Arrays.toString(capturedMouse) +
                '}';
    }
}
