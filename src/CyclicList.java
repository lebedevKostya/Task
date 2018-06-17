import java.util.*;

/**
 * @author K.Lebedev
 *         <p>
 *         Программа решающая логическую задачу.
 *         <p>
 *         Описание задачи : https://github.com/lebedevKostya/Task
 */


public class  CyclicList {
    private ArrayList<Integer> array;
    private int lastPosition;
    private int amount;

    public CyclicList(){
        array = new ArrayList<>();
    }

    /**Заполняет массив на то число, которое укажет пользователь*/
    public void arrayCreator(int n){
        for (int i = 1; i <= n; i++) {
            array.add(i);
        }
    }

    /**
     * Находит позицию которая останется в конце
     * @param m число которое подсчитывает ведущий каждую итерацию
     */
    public void findingPositions(int m){
        while(array.size()!=1) {
            shiftLeft(m);
//            System.out.println(array.get(array.size()-1));
            array.remove(array.size() - 1);


        }
        lastPosition = array.get(0);
    }

    /**
     * Сдвигаает позицию которая должна быть удалена в конец массива
     *  и ставит в начало ту с которой должна начаться следующая итерация
     *  @param m число которое подсчитывает ведущий каждую итерацию
     */
    private void shiftLeft(int m) {
        while(m>=array.size()){
            m -= array.size();
        }
        int length = array.size() - 1;
        ArrayList<Integer> b = new ArrayList<>();
        if (array.size() < m) {
        } else {
            b.addAll(array.subList(m, length + 1));
            b.addAll(array.subList(0, m));
        }
        array = b;
    }

    /**
     * Подсчитывает количество монет в конце игры
     *  @param n общее количество учавствующих в игре
     *  @param m число которое подсчитывает ведущий каждую итерацию
     */
    public void calculationOfTheAmount(int n, int m){
       if(n==1) amount +=m;
       else {
           while (n != 1) {
               if (n > m) amount += m + (n - m) * 2;
               else amount += m;
               n--;
           }
       }
    }


    public int getAmount() {
        return amount;
    }

    public int getLastPosition() {
        return lastPosition;
    }
}
