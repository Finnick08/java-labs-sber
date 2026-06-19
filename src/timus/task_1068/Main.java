package timus.task_1068;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.close();

        long sum = 0;
        int from = Math.min(1, n);
        int to   = Math.max(1, n);

        for (int i = from; i <= to; i++) {
            sum += i;
        }

        System.out.println(sum);
    }
}