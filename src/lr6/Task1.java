package lr6;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Task1 {
    public static void main(String[] args) throws InterruptedException {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("HH:mm:ss");

        Runnable task = () -> {
            String name = Thread.currentThread().getName();
            long end = System.currentTimeMillis() + 10_000;
            while (System.currentTimeMillis() < end) {
                System.out.println(name + " | " + LocalTime.now().format(fmt));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        };

        Thread t1 = new Thread(task, "Поток-1");
        Thread t2 = new Thread(task, "Поток-2");

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Все потоки завершены.");
    }
}