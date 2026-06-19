package timus.task_1025;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        int[] n = new int[k];

        for (int i = 0; i < k; i++) {
            n[i] = in.nextInt();
        }
        in.close();

        // Сортируем по возрастанию — берём самые маленькие партии
        Arrays.sort(n);

        // Нужно большинство партий: k/2 + 1
        int partiesNeeded = k / 2 + 1;

        long total = 0;
        for (int i = 0; i < partiesNeeded; i++) {
            // В каждой партии нужно большинство: n[i]/2 + 1
            total += n[i] / 2 + 1;
        }

        System.out.println(total);
    }
}