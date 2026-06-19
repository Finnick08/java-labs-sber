package lr3;
import java.util.Scanner;

public class Task2 {

    static void toBinary(int n) {
        if (n > 1) {
            toBinary(n / 2);
        }
        System.out.print(n % 2);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите число:");
        int n = in.nextInt();
        in.close();

        System.out.print("Двоичное представление: ");
        toBinary(n);
        System.out.println();
    }
}