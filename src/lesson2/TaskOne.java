package lesson2;

import java.util.Scanner;

public class TaskOne {
    public static void main(String[] args) {


    /*  1. Задача на if
    Дана целочисленная переменная count - количество верных ответов.
    В зависимости от значения этой переменной вывести в консоль оценку:
    100 - 90 правильных ответов - отлично
    89 - 60 правильных ответов - хорошо
    59 - 40 правильных ответов - удовлетворительно
    39 - 0 правильных ответов - попробуйте в следующий раз*/

        Scanner in = new Scanner(System.in);

        System.out.println("Введите количество правильных ответов от 0 до 100: ");

        int count = in.nextInt();
        if(count >= 90 && count <= 100) System.out.println("Оценка: отлично");
        else if(count >= 60 && count <= 89) System.out.println("Оценка: хорошо");
        else if(count >= 40 && count <= 59) System.out.println("Оценка: удовлетворительно");
        else if(count >= 0 && count <= 39) System.out.println("Оценка: попробуйте в следующий раз");
        else System.out.println("Введеное вами число не входит в диапазон от 0 до 100");

    }
}
