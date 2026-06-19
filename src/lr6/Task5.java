package lr6;

import java.util.concurrent.atomic.AtomicInteger;

public class Task5 {

    static int[] array;
    static AtomicInteger globalMax = new AtomicInteger(Integer.MIN_VALUE);

    public static void main(String[] args) throws InterruptedException {
        // Инициализация массива
        int size = 1_000_000;
        array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = (int) (Math.random() * 1_000_000);
        }

        int cores = Runtime.getRuntime().availableProcessors();
        System.out.println("Количество ядер: " + cores);

        Thread[] threads = new Thread[cores];
        int chunkSize = size / cores;

        for (int t = 0; t < cores; t++) {
            final int start = t * chunkSize;
            final int end = (t == cores - 1) ? size : start + chunkSize;

            threads[t] = new Thread(() -> {
                int localMax = Integer.MIN_VALUE;
                for (int i = start; i < end; i++) {
                    if (array[i] > localMax) localMax = array[i];
                }
                // Атомарно обновляем глобальный максимум
                int prev;
                do {
                    prev = globalMax.get();
                } while (localMax > prev && !globalMax.compareAndSet(prev, localMax));
            });

            threads[t].start();
        }

        for (Thread t : threads) t.join();

        System.out.println("Максимальный элемент: " + globalMax.get());
    }
}