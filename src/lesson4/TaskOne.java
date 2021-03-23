package lesson4;

import java.util.Arrays;

public class TaskOne {
    public static void main(String[] args) {
        // 1. Создать одномерный массив типа int на 20 элементов. Заполнить его рандомными значениями от 3 до 500.
        // Поменять местами минимальный и максимальный элементы.

        int[] array = new int[20];
        double min = Double.MIN_VALUE;
        double max = Double.MAX_VALUE;
        int minIndex = -1;
        int maxIndex = -1;


        for (int i = 0; i < array.length; i++) {
            array[i] = (int)(Math.random() * 500 + 3);
        }

        for (int j = 0; j < array.length; j++) {
            if(array[j] < max) {
                max = array[j];
                minIndex = j;
            }
            if(array[j] > min) {
                min = array[j];
                maxIndex = j;
            }
        }

        if(minIndex != -1 && maxIndex != -1){
            System.out.println("Изначальный массив: " + Arrays.toString(array));

            int tempValue = array[minIndex];
            array[minIndex] = array[maxIndex];
            array[maxIndex] = tempValue;
            System.out.println("Массив после замены: " + Arrays.toString(array));
        } else {
            System.out.println("Ошибка");
        }

    }
}
