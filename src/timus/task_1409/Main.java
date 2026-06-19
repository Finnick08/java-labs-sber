package timus.task_1409;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int harry = in.nextInt();
        int larry = in.nextInt();

        int harryMissed = larry - 1;
        int larryMissed = harry - 1;

        System.out.println(harryMissed + " " + larryMissed);
        in.close();
    }
}