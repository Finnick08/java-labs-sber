package lr1;
import java.util.Scanner;
import java.time.Year;

public class Task7 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите ваш возраст: ");
        int age = in.nextInt();

        int currentYear = Year.now().getValue();
        int birthYear = currentYear - age;

        System.out.println("Ваш год рождения: " + birthYear);
        in.close();
    }
}