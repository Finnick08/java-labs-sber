package timus.task_1073;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.close();

        int[] dp = new int[n + 1];
        // Заполняем большим значением (бесконечность)
        for (int i = 1; i <= n; i++) dp[i] = Integer.MAX_VALUE;

        for (int i = 1; i <= n; i++) {
            // Перебираем все квадраты a² <= i
            for (int a = 1; a * a <= i; a++) {
                int prev = dp[i - a * a];
                if (prev != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], prev + 1);
                }
            }
        }

        System.out.println(dp[n]);
    }
}