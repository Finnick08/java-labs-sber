package lr6;

public class Task3 {
    static final Object lock = new Object();
    static int number = 1;
    static final int MAX = 10;

    public static void main(String[] args) throws InterruptedException {
        Thread evenThread = new Thread(() -> {
            synchronized (lock) {
                while (number <= MAX) {
                    // Ждём, пока не придёт чётное число
                    while (number <= MAX && number % 2 != 0) {
                        try { lock.wait(); } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    if (number <= MAX) {
                        System.out.println("Чётный поток: " + number);
                        number++;
                        lock.notifyAll();
                    }
                }
            }
        }, "ЧётныйПоток");

        Thread oddThread = new Thread(() -> {
            synchronized (lock) {
                while (number <= MAX) {
                    // Ждём, пока не придёт нечётное число
                    while (number <= MAX && number % 2 == 0) {
                        try { lock.wait(); } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    if (number <= MAX) {
                        System.out.println("Нечётный поток: " + number);
                        number++;
                        lock.notifyAll();
                    }
                }
            }
        }, "НечётныйПоток");

        oddThread.start();
        evenThread.start();

        oddThread.join();
        evenThread.join();

        System.out.println("Готово.");
    }
}