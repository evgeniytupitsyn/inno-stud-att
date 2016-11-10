package ru.innopolis.uni.course2.twothreadsfive;

import java.util.*;

/**
 * Created by evgeniytupitsyn on 08/11/2016.
 */
public class Main {

    public static ArrayList<Integer> array = new ArrayList<Integer>();
    /**
     * Метод получения псевдослучайного целого числа;
     */
    public static int random()
    {
        final int min = 0; // Минимальное число для диапазона
        final int max = 99; // Максимальное число для диапазона
        final int rnd = rnd(min, max);
        array.add(rnd);
        return rnd;
    }

    /**
     * Метод получения псевдослучайного целого числа от min до max (включая max);
     */
    public static int rnd(int min, int max)
    {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }


    // бежим по всем елементам массива
    // и проверяем, есть ли уже такой елемент в мапе
    // если его нет - ложим в мапу пару <этот елемент, 1> (он встретил первый раз)
    // если он уже был, то по ключу этого елемента увеличичаем число
    // его повторений на 1
    public Map<Integer, Integer> getMap(ArrayList<Integer> array) {
        Map<Integer, Integer> result = new HashMap<>();
        for (int element : array) {
            Integer count = result.get(element);
            if (count == null)
                count = 0;
            result.put(element, ++count);
        }
        return result;
    }

    // Во первых елементов которые повторяются чаще всего может быть несколько
    // по этому возвращаем сет(они все разные) таких елементов
    public Set<Integer> mostPopular(ArrayList<Integer> array) {
        // нашли мапу число - число его повторений в массиве
        Map<Integer, Integer> map = getMap(array);

        // нашли колекцию числа разных повторений
        Collection<Integer> values = map.values();

        // выбрали из этой коллекции наибольшее число(повторений в даном случае)
        Integer max = Collections.max(values);

        // бежим по всем ячейкам мапы
        // и если значение ячейки такое же как максимальное число повторов
        // то добавим в результат ключ этой ячейки
        // (в данном случае это одно из чисел которое встречается чаще всего)
        Set<Integer> result = new HashSet<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (max.equals(entry.getValue())) {
                result.add(entry.getKey());
            }
        }
        return result;
    }

    public static void main(String[] args) throws InterruptedException {
        new Main(3000);
    }

    public Main(int startsession) throws InterruptedException {
        Ruler ruler = new Ruler();

        Thread1sec thread1Sec = new Thread1sec(ruler);
        Thread2 thread2 = new Thread2(ruler, "Count numbers:");
        //System.out.println(mostPopular(array));
        thread1Sec.start();
        thread2.start();

        System.out.println("Work!");
        Thread.sleep(startsession * 1000);

        thread1Sec.interrupt();
        thread2.interrupt();
    }

    class Thread1sec extends Thread {

        private Ruler app;

        public Thread1sec(Ruler app) {
            this.app = app;
        }

        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
                this.app.add();
            }
        }
    }

    class Thread2 extends Thread {

        private Ruler app;
        private String message;

        public Thread2(Ruler app, String message) {
            this.app = app;
            this.message = message;
            /*final Class<Integer> integerClass = Integer.class;

            Class<Integer> clazz = Integer.class;
            Class.forName("java.lang.Integer");*/

        }

        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                int n;
                try {
                    n = app.last();
                    System.out.println(random() + " (random number [0;99])");

                    if (n % 5 == 0)
                        System.out.println(message);

                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    class Ruler {

        private int d = 0;

        public synchronized void add() {
            this.d++;
            notify();
        }

        public synchronized int last() throws InterruptedException {
            wait();
            return this.d;
        }
    }
}
