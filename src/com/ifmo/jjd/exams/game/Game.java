package com.ifmo.jjd.exams.game;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ifmo.jjd.exams.game.enums.MenuItems;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Game implements Serializable {

    transient List<Question> questions;
    int currentQuestionNumber;
    String pathOfQuestionsFile;
    String pathOfSaveFiles;
    transient Menu menu;
    transient BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


    public Game(String pathOfQuestionsFile) {
        this.pathOfQuestionsFile = pathOfQuestionsFile;
        this.menu = new Menu(true);
        initQuestions(pathOfQuestionsFile);
    }

    public Game(String pathOfQuestionsFile, String pathOfSaveFiles) {
        this.pathOfQuestionsFile = pathOfQuestionsFile;
        this.pathOfSaveFiles = pathOfSaveFiles;
        this.menu = new Menu(true);
        initQuestions(pathOfQuestionsFile);
    }

    public Game(String pathOfQuestionsFile, String pathOfSaveFiles, int currentQuestionNumber) {
        this.pathOfQuestionsFile = pathOfQuestionsFile;
        this.pathOfSaveFiles = pathOfSaveFiles;
        this.currentQuestionNumber = currentQuestionNumber;
        this.menu = new Menu(new File(this.pathOfSaveFiles).exists());
        initQuestions(pathOfQuestionsFile);
    }

    public Game(ArrayList<Question> questions) {
        this.questions = questions;
        this.menu = new Menu(new File(this.pathOfSaveFiles).exists());

    }

    public Game(List<Question> questions, int currentQuestionNumber, String pathOfQuestionsFile, String pathOfSaveFiles) {
        this.questions = questions;
        this.currentQuestionNumber = currentQuestionNumber;
        this.pathOfQuestionsFile = pathOfQuestionsFile;
        this.pathOfSaveFiles = pathOfSaveFiles;
    }


    public int getCurrentQuestionNumber() {
        return currentQuestionNumber;
    }

    public String getPathOfQuestionsFile() {
        return pathOfQuestionsFile;
    }

    public String getPathOfSaveFiles() {
        return pathOfSaveFiles;
    }

    public void setCurrentQuestionNumber(int currentQuestionNumber) {
        this.currentQuestionNumber = currentQuestionNumber;
    }

    public void setPathOfQuestionsFile(String pathOfQuestionsFile) {
        this.pathOfQuestionsFile = pathOfQuestionsFile;
    }

    public void setPathOfSaveFiles(String pathOfSaveFiles) {
        this.pathOfSaveFiles = pathOfSaveFiles;
    }

    /**
     * Формирования списка вопросов из json файла
     * @param pathOfQuestionsFile
     */
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

    /**
     * Метод старта игры
     */
    public void start(){
        renderMenu();
    }

    /**
     * Вывод меню
     */
    public void renderMenu(){
        menu.renderMenu();
        this.readUserMenuCommand();
    }

    /**
     * Вывод вопроса с номером currentQuestionNumber и вариантов ответа или информацией об окончании игры
     */
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

    /**
     * Обработка ввода номера ответа на вопрос
     * @param numbersQuestions количество вариантов ответа
     */
    public void readUserQuestionsCommand(List<Integer> numbersQuestions){
        int numberAction;
        System.out.println("Выберите вариант");
        try {
            numberAction = Integer.parseInt(reader.readLine());
            if (numberAction == 9){
                renderMenu();
                return;
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

    /**
     * Обработка ввода номера выбора пункта меню
     */
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

    /**
     * Действия меню
     * @param action
     */
    public void action(MenuItems action){
        if(Objects.isNull(action)) return;
        switch (action){
            case START -> {
                currentQuestionNumber = 0;
                renderQuestion();
            }
            case  RETURN -> {
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

    /**
     * Сохранение игры
     */
    private void saveGame(){
        if(this.writeToFile(new Game(this.pathOfQuestionsFile, this.pathOfSaveFiles, this.currentQuestionNumber), new File(this.pathOfSaveFiles))){
            System.out.println("Игра сохранена");
            this.renderMenu();
        };
    }

    public <T> boolean writeToFile(T object, File file){
        boolean result = false;
        try(FileOutputStream fileOutput = new FileOutputStream(file);
            ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput)){
            objectOutput.writeObject(object);
            result = true;

        } catch (IOException e){
            System.out.println("Ошибка записи в файл");
            e.printStackTrace();
        }
        return result;
    }

    public <T> T readFromFile(File file){
        T o = null;
        try(FileInputStream fileInput = new FileInputStream(file);
            ObjectInputStream objectInput = new ObjectInputStream(fileInput)){
            o = (T) objectInput.readObject();
            System.out.println("Игра загружена");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Ошибка чтения из файла");
        }
        return  o;
    }

    private void logOut(){
        System.out.println("Вы вышли из игры");
    }


    /**
     * Метод загрузи игры
     */
    private void loadGame(){
        System.out.println("Загрузка .....");
        Game fromFile = this.readFromFile(new File(this.pathOfSaveFiles));
        this.currentQuestionNumber = fromFile.getCurrentQuestionNumber();
        this.pathOfQuestionsFile = fromFile.getPathOfQuestionsFile();
        this.pathOfSaveFiles = fromFile.getPathOfSaveFiles();
        this.renderMenu();
    }
}
