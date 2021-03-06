package com.ifmo.jjd.lesson6.tasktwo;

public class Mouse {
    private int speed;

    public Mouse(int speed) {
        setSpeed(speed);
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        if(speed < 0) throw new IllegalArgumentException("Mouse -> speed < 0 ");
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "Mouse{" +
                "speed=" + speed +
                '}';
    }
}
