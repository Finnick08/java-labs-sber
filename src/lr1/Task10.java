package lr1;
import java.util.Scanner;

public class Task10 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите первое число: ");
        int a = in.nextInt();

        System.out.print("Введите второе число: ");
        int b = in.nextInt();

        System.out.println("Сумма чисел: " + (a + b));
        System.out.println("Разность чисел: " + (a - b));
        in.close();
    }
}