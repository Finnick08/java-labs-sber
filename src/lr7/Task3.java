package lr7;
import java.io.*;
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите путь к файлу:");
        String filePath = scanner.nextLine();
        scanner.close();

        int lineCount = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            while (br.readLine() != null) {
                lineCount++;
            }
            System.out.println("Количество строк в файле: " + lineCount);
        } catch (IOException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}