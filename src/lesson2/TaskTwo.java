package lesson2;

import java.util.Scanner;

public class TaskTwo {
    public static void main(String[] args) {

           /*2. Задача на switch
        Пользователь вводит 3 числа:
        1е - первый операнд
        2e - второй операнд
        3е - оператор
        В зависимости от третьего введенного числа нужно вывести в консоль:
        сумму, разность, умножение, деления чисел, которые ввел пользователь.
        Если 3е введенное число 3, нужно найти сумму,
        если 5 - разность,
                если 7 - результат умножения,
                если 9 - результат деления.*/

        Scanner in = new Scanner(System.in);

        System.out.println("Введите три числа (первый операнд, второй операнд, оператор)");
        double firstOperand = in.nextDouble();
        double secondOperand = in.nextDouble();
        int operator = in.nextInt();

        switch (operator){
            case 3:
                System.out.println("Сумма операндов: " + ( firstOperand + secondOperand));
                break;
            case 5:
                System.out.println("Разность операндов: " + ( firstOperand - secondOperand));
                break;
            case 7:
                System.out.println("Результат умножения операндов: " + (firstOperand * secondOperand));
                break;
            case 9:
                System.out.println("Результат деления операндов: " + (firstOperand / secondOperand));
                break;
        }
    }
}
