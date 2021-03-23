package lesson4;

import java.util.Arrays;

public class TaskTwo {
    public static void main(String[] args) {
//        2. Дан массив целых чисел [78, 32, 76, 100, 0, 6301, 331, 77, 24, 2, 90].
//        Образуйте из него два отсортированных по возрастанию массива, содержащих четные и нечетные числа.


        int[] array = {78, 32, 76, 100, 0, 6301, 331, 77, 24, 2, 90};
        Arrays.sort(array);

        int countEvenNumbers = 0;
        int countNonEvenNumbers = 0;
        int stepEvenNumbers = 0;
        int stepNonEvenNumbers = 0;

        for (int k : array) {
            if (k % 2 == 0) {
                countEvenNumbers++;
            } else {
                countNonEvenNumbers++;
            }
        }

        int[] evenNumbersArray = new int[countEvenNumbers];
        int[] nonEvenNumbersArray = new int[countNonEvenNumbers];


        for (int j : array) {
            if (j % 2 == 0) {
                evenNumbersArray[stepEvenNumbers] = j;
                stepEvenNumbers++;
            } else {
                nonEvenNumbersArray[stepNonEvenNumbers] = j;
                stepNonEvenNumbers++;
            }
        }

        System.out.println("Изначальный массив: " + Arrays.toString(array));
        System.out.println("Массив четных чисел: " + Arrays.toString(evenNumbersArray));
        System.out.println("Массив нечетных чисел: " + Arrays.toString(nonEvenNumbersArray));
    }
}
