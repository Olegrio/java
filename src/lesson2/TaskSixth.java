package lesson2;

import java.util.Scanner;

public class TaskSixth {
    public static void main(String[] args) {
/*        6. Пользователь!!! загадывает число в диапазоне от [1 до 100]
        Программа пытается его угадать (используйте метод !!!бинарного поиска - деление отрезка на 2).
        Программа может задавать пользователю вопросы:
        Число равно ...? / Число больше ...? / Число меньше ...?
        и в зависимости от ответа пользователя принимать решения.
        !!! Вместо текстовых ответов ДА/НЕТ, используйте числа 0 - НЕТ и 1 - ДА*/

        Scanner in = new Scanner(System.in);
        int min = 1, max = 100;
        int randomNum = (int)((Math.random() * (max - min + 1)) + min);
        int answerNum;

        System.out.println("Загадайте чило в диапазоне от 1 до 100, включительно");
        while (true) {

            System.out.println("Число равно " + randomNum);
            answerNum = in.nextInt();

            if(answerNum == 1){
                System.out.println("Ура угадал");
                break;
            } else {
                System.out.println("Число больше " + ((max - min)/2 + min) + " ?");
                answerNum = in.nextInt();

                if(answerNum == 1){
                    min = (max - min)/2 + min;
                } else {
                    max = (max - min)/2 + min;
                }
                System.out.println(min + "," + max);
                randomNum = (int)((Math.random() * (max - min + 1)) + min);
            }
        }
    }
}
