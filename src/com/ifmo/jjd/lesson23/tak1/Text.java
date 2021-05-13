package com.ifmo.jjd.lesson23.tak1;

public class Text extends Message{

    private String text;
    private String[] letters;
    private Object[] obj = new Object[2];
    public Text(String sender) {
        super(sender);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
