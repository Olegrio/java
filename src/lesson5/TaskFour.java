package lesson5;

import java.util.Arrays;
import java.util.Scanner;

public class TaskFour {
    public static void main(String[] args) {
//        4. Заменить все буквы в слове на строчные, а первую букву на заглавную
//        Например, дано hello, получаем Hello / дано HeLLO, получаем Hello

        Scanner in = new Scanner(System.in);
        System.out.println("Введите слово");
        String string = in.nextLine();


        string = string.toLowerCase().strip();
        String[] stringArray = string.split("");
        stringArray[0] = stringArray[0].toUpperCase();

        string = String.join("", stringArray);
        System.out.println(string);
    }
}
