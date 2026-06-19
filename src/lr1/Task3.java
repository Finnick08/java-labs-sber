package lr1;
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите текущий день недели: ");
        String day = in.nextLine();

        System.out.print("Введите название месяца: ");
        String month = in.nextLine();

        System.out.print("Введите дату (номер дня в месяце): ");
        int date = in.nextInt();

        System.out.printf("Сегодняшняя дата: %s, %d %s\n", day, date, month);
        in.close();
    }
}