package lr6;

import java.util.concurrent.atomic.AtomicLong;

public class Task6 {

    static int[] array;
    static AtomicLong globalSum = new AtomicLong(0);

    public static void main(String[] args) throws InterruptedException {
        // Инициализация массива
        int size = 1_000_000;
        array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = i + 1;
        }

        int cores = Runtime.getRuntime().availableProcessors();
        System.out.println("Количество ядер: " + cores);

        Thread[] threads = new Thread[cores];
        int chunkSize = size / cores;

        for (int t = 0; t < cores; t++) {
            final int start = t * chunkSize;
            final int end = (t == cores - 1) ? size : start + chunkSize;

            threads[t] = new Thread(() -> {
                long localSum = 0;
                for (int i = start; i < end; i++) {
                    localSum += array[i];
                }
                // Атомарно добавляем локальную сумму к глобальной
                globalSum.addAndGet(localSum);
            });

            threads[t].start();
        }

        for (Thread t : threads) t.join();

        System.out.println("Сумма элементов: " + globalSum.get());

        // Проверка: сумма 1..N = N*(N+1)/2
        long expected = (long) size * (size + 1) / 2;
        System.out.println("Ожидаемая сумма: " + expected);
        System.out.println("Результат верный: " + (globalSum.get() == expected));
    }
}