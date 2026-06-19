package lr1;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Введите фамилию: ");
        String surname = in.nextLine();

        System.out.print("Введите имя: ");
        String name = in.nextLine();

        System.out.print("Введите отчество: ");
        String patronymic = in.nextLine();

        System.out.printf("Hello %s %s %s \n", surname, name, patronymic);
        in.close();
    }
}