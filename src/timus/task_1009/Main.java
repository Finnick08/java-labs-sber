package timus.task_1009;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        in.close();

        // dp[0] = числа, заканчивающиеся на 0
        // dp[1] = числа, заканчивающиеся на ненулевую цифру
        long endZero = 0;          // первая цифра не может быть 0
        long endNonZero = k - 1;   // первая цифра: 1..K-1

        for (int i = 2; i <= n; i++) {
            long newEndZero    = endNonZero;             // перед 0 может стоять только ненулевая
            long newEndNonZero = (endZero + endNonZero) * (k - 1); // (k-1) ненулевых вариантов
            endZero    = newEndZero;
            endNonZero = newEndNonZero;
        }

        System.out.println(endZero + endNonZero);
    }
}