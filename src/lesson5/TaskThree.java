package lesson5;

import java.util.Arrays;
import java.util.Scanner;

public class TaskThree {
    public static void main(String[] args) {
//        3. Написать функцию, которая проверяет, является ли строка палиндромом.
//                Палиндром — это число, буквосочетание, слово или текст, которые одинаково читаются по буквам или по словам как слева направо,
//        так и справа налево.
//        Например, 202 - палиндром / fafaf - палиндром / а роза упала на лапу Азора - палиндром

        Scanner in = new Scanner(System.in);
        System.out.println("Введите исходную строку");
        String string = in.nextLine();
        string = string.replaceAll(" ", "");

        String[] arrString = string.split("");
        StringBuilder reverseString = new StringBuilder();

        for (int i = arrString.length - 1; i >= 0; i--) {
            reverseString.append(arrString[i]);
        }

        if(string.equalsIgnoreCase(reverseString.toString())) {
            System.out.println("Строка является палиндромом");
        } else {
            System.out.println("Строка не является палиндромом");
        }

    }
}
