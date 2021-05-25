package com.ifmo.jjd.exams.game;

import com.ifmo.jjd.exams.game.enums.QuestionOutcomeTypes;

import java.util.List;
import java.util.Map;

public class Question {
    private String name;
    private String question;
    private int number;
    private QuestionOutcomeTypes type;
    private List<Map<String, Integer>> answers;

    public QuestionOutcomeTypes getType() {
        return type;
    }

    public void setType(QuestionOutcomeTypes type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Map<String, Integer>> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Map<String, Integer>> answers) {
        this.answers = answers;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "\nQuestion{" +
                "name='" + name + '\'' +
                ", question='" + question + '\'' +
                ", number=" + number +
                ", type=" + type +
                ", answers=" + answers +
                '}';
    }
}
