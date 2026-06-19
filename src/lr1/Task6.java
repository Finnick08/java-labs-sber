package lr1;
import java.util.Scanner;
import java.time.Year;

public class Task6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите ваше имя: ");
        String name = in.nextLine();

        System.out.print("Введите год вашего рождения: ");
        int birthYear = in.nextInt();

        int currentYear = Year.now().getValue();
        int age = currentYear - birthYear;

        System.out.printf("Вас зовут %s, ваш возраст: %d\n", name, age);
        in.close();
    }
}