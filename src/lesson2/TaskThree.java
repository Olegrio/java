package lesson2;

import java.text.DecimalFormat;
import java.util.Scanner;

public class TaskThree {
    public static void main(String[] args) {

/*        3. Задача на цикл while
        Считать с консоли количество тарелок и количество моющего средства
        Моющее средство расходуется из расчета 0.5 на 1 тарелку
        В цикле выводить сколько моющего средства осталось после мытья каждой тарелки.
                В конце вывести сколько тарелок осталось, когда моющее средство закончилось или
        наоборот.*/

        Scanner in = new Scanner(System.in);

        System.out.println("Введите количество тарелок:");
        int numberOfPlates = in.nextInt();

        System.out.println("Введите количество моющего стредства:");
        double numberOfFairy = in.nextFloat();

        if (numberOfPlates >= 0 && numberOfFairy >= 0) {
            int step = 0;
            if(numberOfFairy < .5) {
                System.out.println("Моющего средства не хватает");
            }
            while(numberOfPlates > 0 && numberOfFairy >= 0.5 ){
                numberOfFairy -= .5;
                ++step;
                --numberOfPlates;

                System.out.println("-------------------- Тарелка помыта -----------------------");
                if (numberOfPlates == 0){
                    System.out.println("Помыто тарелок: " + step );
                }
                if ( numberOfFairy < 0.5) {
                    System.out.println("Моющее средство закончилось");
                    System.out.println("Осталось тарелок: " + numberOfPlates);
                } else {
                    System.out.println("Осталось моющего средства: " + String.format("%.1f", numberOfFairy));
                }
            }
        } else {
            System.out.println("Введенные данные некорректны");
        }


    }
}
