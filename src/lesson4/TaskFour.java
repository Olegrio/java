package lesson4;

import java.util.Arrays;

public class TaskFour {
    public static void main(String[] args) {
        // 4. Создать массив из чётных чисел [2, 4, 6, 8, 10, 12 ... 18, 20]
        // и вывести элементы массива в консоль в обратном порядке (20 18 16 ... 4 2)

        int[] array = new int[11];
        for (int i = 0, value = 0; i < array.length; i++, value +=2 ) {
            array[i] = value;
        }

        //int[] array = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20} ;

        int[] newArray = array.clone();
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = newArray[i] * -1;
        }

        Arrays.sort(newArray);

        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = newArray[i] * -1;
            System.out.println(newArray[i]);
        }
    }
}
