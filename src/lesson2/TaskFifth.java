package lesson2;

import java.util.Scanner;

public class TaskFifth {
    public static void main(String[] args) {
/*        5. Задача на Math.random() и if
        Написать код, который будет проверять попало ли случайно сгенерированное целое число из отрезка [10;500]
        в интервал (25;200) и выводить результат в консоль.
                Примеры работы программы:
        Число 345 не содержится в интервале (25;200)
        Число 110 содержится в интервале (25;200)*/
            int max = 500, min = 10;
            int randomNum = (int)((Math.random() * (max - min + 1)) + min);
            if(randomNum > 25 && randomNum < 200){
                System.out.println("Число " + randomNum + " содержится в интервале (25;200)");
            } else {
                System.out.println("Число " + randomNum + " не содержится в интервале (25;200)");
            }
        }
}
