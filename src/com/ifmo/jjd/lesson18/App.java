package com.ifmo.jjd.lesson18;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class App {
    public static void main(String[] args) {

//        1. Написать декораторы, наследующиеся от FilterOutputStream и FilterInputStream,
//        шифрующие и дешифрующие исходящие и входящие байты XOR-шифрованием. ^
//
//        программа -> decorator(outputStream) -> outputStream
//        программа <- decorator(inputStream) <- inputStream

        String text = "Горюнов направляется домой, в подмосковную Лобню. Она, в отличие от Москвы, осталась той же. " +
               "Героя охватывают воспоминания: школьные годы, бывшая девушка, друзья. " +
               "Илья мечтает наконец увидеть мать, с которой он жил до ареста, но, приехав домой, узнаёт от соседки, что мать умерла от инфаркта за день до его возвращения.";


        try(OutputDecorator outputDecorator = new OutputDecorator(new FileOutputStream("encode.txt"));
            InputDecorator inputDecorator = new InputDecorator(new FileInputStream("encode.txt"))
        ) {
            // Запись в файл с шифрованием
            outputDecorator.write(outputDecorator.encode(text));

            // Чтение из файла с дешифровкой
            System.out.println(inputDecorator.decode(inputDecorator.readAllBytes()));

        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
