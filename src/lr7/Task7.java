package lr7;
import java.io.*;
import java.util.Scanner;

public class Task7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите название файла:");
        String filePath = scanner.nextLine();
        System.out.println("Введите текст для записи:");
        String text = scanner.nextLine();
        scanner.close();

        try (PrintWriter pw = new PrintWriter(new FileWriter(filePath))) {
            pw.print(text);
            System.out.println("Записано символов: " + text.length());
        } catch (IOException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}