package timus.task_1044;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.close();

        int half = n / 2;
        int limit = (int) Math.pow(10, half); // 10^(N/2)
        int maxSum = 9 * half;                // максимальная сумма цифр

        // cnt[s] = количество half-значных чисел (с ведущими нулями) с суммой цифр s
        long[] cnt = new long[maxSum + 1];

        for (int i = 0; i < limit; i++) {
            int sum = 0;
            int num = i;
            for (int d = 0; d < half; d++) {
                sum += num % 10;
                num /= 10;
            }
            cnt[sum]++;
        }

        // Счастливый билет = левая половина с суммой s × правая половина с суммой s
        long result = 0;
        for (int s = 0; s <= maxSum; s++) {
            result += cnt[s] * cnt[s];
        }

        System.out.println(result);
    }
}