package lesson2;

import java.util.Scanner;

public class TaskFour {
    public static void main(String[] args) {


        /*4. Программа загадывает число в диапазоне [1;9]
        Пользователь вводит число с клавиатуры
        Программа в зависимости от введенного числа выводит в консоль следующее:
        "загаданное число больше"
        "загаданное число меньше"
        "Вы угадали" (программа завершает работу)
        если введен 0, выводит "выход из программы" (программа завершает работу)*/

        Scanner in = new Scanner(System.in);
        int min = 1, max = 9;
        int randomNum = (int)((Math.random() * (max - min + 1)) + min);

        System.out.println("Введите число от 1 до 9");
        int userNum = in.nextInt();

        if(userNum >= 1 && userNum <= 9 ){
            while (true){
                if (userNum == 0) break;
                if (userNum > randomNum){
                    System.out.println("загаданное число меньше");
                    System.out.println("Введите число от 1 до 9");
                    userNum = in.nextInt();
                } else if(userNum == randomNum){
                    System.out.println("Вы угадали");
                    break;
                } else {
                    System.out.println("загаданное число больше");
                    System.out.println("Введите число от 1 до 9");
                    userNum = in.nextInt();
                }
            }
        } else {
            System.out.println("Введенное чило не входит в диапазон от 1 до 9");
        }
    }
}
