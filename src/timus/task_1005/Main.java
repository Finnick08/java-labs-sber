package timus.task_1005;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; i++) w[i] = in.nextInt();
        in.close();

        int minDiff = Integer.MAX_VALUE;

        // Перебираем все 2^n разбиений
        for (int mask = 0; mask < (1 << n); mask++) {
            int sum1 = 0, sum2 = 0;
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) sum1 += w[i];
                else sum2 += w[i];
            }
            minDiff = Math.min(minDiff, Math.abs(sum1 - sum2));
        }

        System.out.println(minDiff);
    }
}