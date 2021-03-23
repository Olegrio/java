package lesson4;

import java.lang.reflect.Array;
import java.util.Arrays;

public class TaskSixth {
    public static void main(String[] args) {
//        5. Создать массив из 11 случайных целых чисел из отрезка [-1;1], вывести массив в консоль.
//        Определить какой элемент встречается в массиве чаще всего и вывести информацию об этом в консоль.

        int[] array = new int[11];
        int min = -1;
        int max = 1;
        int numberRepeatingElements = 0;

        // Определяем возможное количесво целых чисел в диапазоне [-1;1]
        for (int i = min; i <= max ; i++) {
            numberRepeatingElements++;
        }

        // Создаем массив целых чисел которые могут повторяться и массив с количеством их повторения
        int[] repeatingElementsArray = new int[numberRepeatingElements];
        int[] countRepeatingElementsArray = new int[numberRepeatingElements];
        for (int i = 0, temp = 0; i < numberRepeatingElements; i++, temp++) {
            repeatingElementsArray[i] = min + temp;
        }

        // Создаем массив из целых чисел из отрезка [-1;1]
        for (int i = 0; i < array.length; i++) {
            array[i] = min + (int)(Math.random() * ((max - min) + 1));
        }

        // Определяем сколько раз повторялось каждое из возможных чисел
        for (int item : array) {
            for (int j = 0; j < repeatingElementsArray.length; j++) {
                if(item == repeatingElementsArray[j]) {
                    countRepeatingElementsArray[j] = countRepeatingElementsArray[j] + 1;
                }
            }
        }

        double maxValue = Double.MIN_VALUE;

        System.out.println("Массив: " + Arrays.toString(array));

        // Находим максимальное количество повторений
        for (int j : countRepeatingElementsArray) {
            if (j >= maxValue) {
                maxValue = j;
            }
        }

        // Выводим число/числа с наибольшим количеством повторений
        System.out.println("Чаще других встречалось: ");
        for (int i = 0; i < countRepeatingElementsArray.length; i++) {
            if(countRepeatingElementsArray[i] == (int)maxValue){
                System.out.println("Число '" + repeatingElementsArray[i] + "' " + countRepeatingElementsArray[i] + " - раз");
            }

        }

    }
}
