package lesson5;

import java.util.Arrays;
import java.util.Scanner;

public class TaskTwo {
    public static void main(String[] args) {
//        2. Найти количество вхождений одной строки в другую.
//         Например, строка "дом" встречается в строке "дом домик домой одомашненный" 4 раза


        Scanner in = new Scanner(System.in);
        System.out.println("Введите исходную строку");
        String string = in.nextLine();

        System.out.println("Введите строку поиска");
        String stringSearch = in.nextLine();

        String tempString = string.replaceAll(stringSearch,stringSearch + "_");
        String[] array = tempString.split(stringSearch);

        if(array.length - 1 != 0){
            System.out.println("Подстрока '" + stringSearch + "' встречается в строке '" + string + "' " + (array.length - 1) + " раза");
        } else {
            System.out.println("Подстрока '" + stringSearch + "' не встречается в строке '" + string + "'");
        }
    }
}
