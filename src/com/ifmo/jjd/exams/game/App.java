package com.ifmo.jjd.exams.game;

public class App {
    public static void main(String[] args) {

        Game game = new Game(
                "lesson/src/com/ifmo/jjd/exams/game/resources/questions.json",
                "lesson/src/com/ifmo/jjd/exams/game/resources/save.bin");
        game.start();

    }
}
