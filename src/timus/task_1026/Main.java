package timus.task_1026;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] db = new int[n];
        for (int i = 0; i < n; i++) db[i] = in.nextInt();

        // Пропускаем разделитель "###"
        in.next();

        Arrays.sort(db);

        int k = in.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k; i++) {
            int query = in.nextInt();
            sb.append(db[query - 1]).append("\n"); // индекс с 1
        }

        System.out.print(sb);
        in.close();
    }
}