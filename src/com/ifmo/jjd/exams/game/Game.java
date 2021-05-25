package com.ifmo.jjd.exams.game;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ifmo.jjd.exams.game.enums.MenuItems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Game implements Serializable {

    List<Question> questions;
    int currentQuestionNumber;
    String pathOfQuestionsFile;
    String pathOfSaveFiles;
    Menu menu;
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


    public Game(String pathOfQuestionsFile) {
        this.pathOfQuestionsFile = pathOfQuestionsFile;
        this.menu = new Menu(false);
        initQuestions(pathOfQuestionsFile);
    }

    public Game(String pathOfQuestionsFile, String pathOfSaveFiles) {
        this.pathOfQuestionsFile = pathOfQuestionsFile;
        this.pathOfSaveFiles = pathOfSaveFiles;
        this.menu = new Menu(true);
        initQuestions(pathOfQuestionsFile);
    }

    public Game(ArrayList<Question> questions) {
        this.questions = questions;
        this.menu = new Menu(false);

    }

    public void initQuestions(String pathOfQuestionsFile){
        ObjectMapper mapper = new ObjectMapper();
        try {
            String jsonString = Files.readString(Path.of(pathOfQuestionsFile));
            this.questions = mapper.readValue(jsonString, new TypeReference<>() {});

        } catch (IOException e) {
            System.out.println("Не удается найти файл с вопросами");
            e.printStackTrace();
        }
    }

    public void start(){
        //System.out.println(questions);
        renderMenu();
    }

    public void renderMenu(){
        menu.renderMenu();
        this.readUserMenuCommand();
    }

    public void renderQuestion(){
        for (Question question : questions) {
            if(question.getNumber() == currentQuestionNumber){
                System.out.println(question.getQuestion());
                switch (question.getType()){
                    case WIN -> System.out.println("Вы выиграли");
                    case LOST -> System.out.println("Вы проиграли");
                    case IN_PROGRESS, START -> {
                        List<Integer> numbersQuestions = new ArrayList<>();
                        question.getAnswers().forEach(item ->{
                        for(Map.Entry<String, Integer> entry: item.entrySet()){
                            numbersQuestions.add(entry.getValue());
                            System.out.println("- " + entry.getKey() + " - для выбора нажмите " + (numbersQuestions.size() - 1));
                            }
                        });
                        System.out.println("- Открыть меню - для выбора нажмите 9");
                        readUserQuestionsCommand(numbersQuestions);
                    }
                }
                return;
            }
        }
    }
    public void readUserQuestionsCommand(List<Integer> numbersQuestions){
        int numberAction;
        System.out.println("Выберите вариант");
        try {
            numberAction = Integer.parseInt(reader.readLine());
            if (numberAction == 9){
                renderMenu();
            }
            if(numberAction > numbersQuestions.size()){
                System.out.println("Не удалось распознать команду, попробуйте снова.");
                this.readUserQuestionsCommand(numbersQuestions);
            } else {
                currentQuestionNumber = numbersQuestions.get(numberAction);
                renderQuestion();
            }
        } catch (IOException e) {
            System.out.println("Не удалось распознать команду, попробуйте снова.");
            this.readUserQuestionsCommand(numbersQuestions);
        }
    }

    public void readUserMenuCommand(){
        int numberAction;
        System.out.println("Выберите вариант");
        try {
            numberAction = Integer.parseInt(reader.readLine());
            this.action(menu.getAction(numberAction));
        } catch (IOException e) {
            System.out.println("Не удалось распознать команду, попробуйте снова.");
            this.readUserMenuCommand();
        }

    }

    public void action(MenuItems action){
        if(Objects.isNull(action)) return;
        switch (action){
            case START, RETURN -> {
                renderQuestion();
            }
            case SAVE -> {
                saveGame();
            }
            case LOG_OUT -> {
                logOut();
            }
            case LOAD -> {
                loadGame();
            }
        }
    }

    private void saveGame(){
        System.out.println(MenuItems.SAVE.getName());
    }
    private void logOut(){
        System.out.println(MenuItems.LOG_OUT.getName());
    }
    private void loadGame(){
        System.out.println(MenuItems.LOAD.getName());
    }


}
