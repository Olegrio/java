package com.ifmo.jjd.lesson19.client;

public class ClientApp {
    public static void main(String[] args) {
        new Client("127.0.0.1", 8885).start();
    }
}
