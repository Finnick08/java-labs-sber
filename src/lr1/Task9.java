package lr1;
import java.util.Scanner;

public class Task9 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите число: ");
        int n = in.nextInt();

        int a = n - 1;
        int b = n;
        int c = n + 1;
        int sum = a + b + c;
        int d = sum * sum;

        System.out.printf("Последовательность: %d, %d, %d, %d\n", a, b, c, d);
        in.close();
    }
}