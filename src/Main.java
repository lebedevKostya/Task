import java.util.*;

/**
 * @author K.Lebedev
 *         <p>
 *         Программа решающая логическую задачу.
 *         <p>
 *         Описание задачи : https://github.com/lebedevKostya/Task
 */

public class Main {

    public static void main(String[] args)
    {
        while(true) {
            int n = 0;
            int m = 0;
            Scanner in = new Scanner(System.in);
            try {
                System.out.println("Введите число n(общее число людей): ");
                n = in.nextInt();
                System.out.println("Введите число m(число людей которое отсчитал ведущий): ");
                m = in.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Ввод не является числом. Либо превышает допустимый размер! Повторите ввод!\n");
                continue;

            }
            CyclicList list = new CyclicList();
            list.arrayCreator(n);
            list.findingPositions(m);
            list.calculationOfTheAmount(n,m);
            System.out.println( "Общее число человек: " + n + "\nЧисло человек которых отсчитал ведущий: " + m
                    + "\nПоследний элемент будет под номером: " + list.getLastPosition()
                    + "\nСумма всех монет будет равна: " + list.getAmount()
                    + "\n");

        }
    }
}
