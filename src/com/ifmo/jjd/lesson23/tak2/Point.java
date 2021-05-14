package com.ifmo.jjd.lesson23.tak2;

@Component(fileName = "point.properties", version = 2)
public class Point {
    @Required
    public int x;
    @Required
    public int y;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

}
