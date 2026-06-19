package lr7;
import java.io.*;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите данные для записи в файл:");
        String data = scanner.nextLine();

        String filePath = "console_input.txt";

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            bw.write(data);
            System.out.println("Данные записаны в файл.");
        } catch (IOException e) {
            System.out.println("Ошибка записи: " + e.getMessage());
        }

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            System.out.println("Содержимое файла: " + br.readLine());
        } catch (IOException e) {
            System.out.println("Ошибка чтения: " + e.getMessage());
        }

        new File(filePath).delete();
        scanner.close();
    }
}