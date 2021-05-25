package com.ifmo.jjd.exams.game;

public class App {
    public static void main(String[] args) {

        Game game = new Game("resources/questions.json");
        game.start();

    }
}
