package timus.task_1014;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        in.close();

        if (n == 0) { System.out.println(10); return; }
        if (n == 1) { System.out.println(1);  return; }

        StringBuilder digits = new StringBuilder();

        // Делим на цифры от 9 до 2
        for (int d = 9; d >= 2; d--) {
            while (n % d == 0) {
                digits.append(d);
                n /= d;
            }
        }

        // Если осталось что-то больше 9 — решения нет
        if (n > 1) { System.out.println(-1); return; }

        // Разворачиваем — меньшие цифры идут первыми
        System.out.println(digits.reverse().toString());
    }
}