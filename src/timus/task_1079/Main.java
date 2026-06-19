package timus.task_1079;
import java.util.Scanner;

public class Main {
    static final int MAX_N = 100000;
    static long[] a = new long[MAX_N + 1];

    public static void main(String[] args) {
        // Вычислим массив
        a[0] = 0;
        a[1] = 1;
        for (int i = 1; i * 2 + 1 <= MAX_N; i++) {
            a[2 * i] = a[i];
            if (2 * i + 1 <= MAX_N) {
                a[2 * i + 1] = a[i] + a[i + 1];
            }
        }

        // Вычислим префиксные максимумы
        long[] prefMax = new long[MAX_N + 1];
        prefMax[0] = a[0];
        for (int i = 1; i <= MAX_N; i++) {
            prefMax[i] = Math.max(prefMax[i - 1], a[i]);
        }

        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            if (n == 0) break;
            System.out.println(prefMax[n]);
        }
        in.close();
    }
}