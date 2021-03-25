package lesson5;

import java.util.Arrays;
import java.util.Scanner;

public class TaskOne {
    public static void main(String[] args) {
//        1. Задать массив на n слов.
//                В цикле считывать с консоли слова (scanner.nextLine()),
//                и добавлять их в массив (добавлять новое слово в массив можно только, если в нем его еще нет).
//        В итоге в массиве будут только уникальные слова.
//        Выход их программы по слову exit (его в массив не добавлять) или если массив заполнен
//        Перед завершением программы, вывести получившийся массив в консоль

//
        Scanner in = new Scanner(System.in);

        System.out.println("Введите длину массива");
        int arrLen = Integer.parseInt(in.nextLine());

        String[] arrWords = new String[arrLen];
        String word;
        boolean isFound = false;

        for (int i = 0; i <= arrWords.length; i++) {
            // если массив заполнен выводим его и выходим из программы
            if(i == arrWords.length){
                System.out.println(Arrays.toString(arrWords));
                break;
            }

            System.out.println("Введите слово");
            word = in.nextLine();

            // если введенное слово exit выводим заполненную часть массива и выходим из программы
            if(word.equals("exit")){
                System.out.println(Arrays.toString(Arrays.copyOf(arrWords, i)));
                break;
            } else {
                // поиск введенного слова в массиве
                for (String arrWord : arrWords) {
                    if(word.equals(arrWord)) {
                        isFound = true;
                        i--;
                        break;
                    }
                }
                if(!isFound) arrWords[i] = word;
                isFound = false;
            }
        }


    }
}
