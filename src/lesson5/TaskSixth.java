package lesson5;

import java.util.Scanner;

public class TaskSixth {
    public static void main(String[] args) {
        // Вводится с клавиатуры массив слов. Определить, сколько слов начинается на определенную букву.

        Scanner in = new Scanner(System.in);
        System.out.println("Введите слова через пробел");
        String string = in.nextLine();

        System.out.println("Введите букву для поиска");
        String letter = in.nextLine().toLowerCase();

        String[] arrayString = string.split(" ");
        int count = 0;

        for (int i = 0; i < arrayString.length; i++) {
            arrayString[i] = arrayString[i].trim().toLowerCase();
            if(arrayString[i].startsWith(letter)) count++ ;
        }
        System.out.println(Integer.toString(count).concat(" слов начинается с буквы '").concat(letter).concat("'"));
    }
}
