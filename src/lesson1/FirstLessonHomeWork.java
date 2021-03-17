package lesson1;

public class FirstLessonHomeWork {
    public static void main(String[] args) {
        /*1. Создание проекта, структура и настройки проекта.*/

       /* 2. Задача на тернарный оператор
        Даны переменные типа long start и end.
        Если start меньше end переменной between присвоить значение end - start, в противном случае -1*/

        long start, end;
        start = 1_000_000_000L;
        end = 10_000_000_000L;

        long between = start < end ? end - start : -1;
        System.out.println("Task 2: between = " + between);

       /* 3. Задача на арифметические операторы
        Найти сумму цифр 2х значного числа*/

        int number = 83;
        int numberSum = (number / 10) // 1 цифра
                + (number - (number / 10) * 10); // 2 цифра
        System.out.println("Task 3: numberSum = " + numberSum);


       /* 4. Задача на арифметические операторы
        Найти сумму цифр 3х значного числа*/

        int numberTwo = 578;
        int numberTwoSum = (numberTwo / 100) // 1 цифра
                + (numberTwo / 10) - (numberTwo / 100) * 10 // 2 цифра
                + numberTwo - (numberTwo / 10) * 10; // 3 цифра

        System.out.println("Task 4: sumTwo = " + numberTwoSum);
    }
}
