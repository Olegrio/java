package lesson4;

import java.lang.reflect.Array;
import java.util.Arrays;

public class TaskThree {
    public static void main(String[] args) {
//        3. Дан массив целых чисел [-321, 894, -45, 782, -29, 12, -88]. Отрицательные элементы массива перенести в новый массив.
//        Размер массива должен быть равен количеству отрицательных элементов.


        int[] array = {-321, 894, -45, 782, -29, 12, -88};
        int lengthNewArray = 0;
        int step = 0;

        for (int item : array) {
            if(item < 0) {
                lengthNewArray++;
            }
        }
        int[] newArray = new int[lengthNewArray];

        for (int item : array) {
            if(item < 0) {
                newArray[step] = item;
                step++;
            }
        }

        System.out.println("Массив отрицательных чисел: " + Arrays.toString(newArray));
    }
}
