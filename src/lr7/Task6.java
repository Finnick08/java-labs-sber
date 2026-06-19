package lr7;
import java.io.*;
import java.util.Scanner;

public class Task6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя файла:");
        String filePath = scanner.nextLine();
        System.out.println("Введите слово для поиска:");
        String word = scanner.nextLine();
        scanner.close();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean found = false;
            while ((line = br.readLine()) != null) {
                if (line.contains(word)) {
                    System.out.println(line);
                    found = true;
                }
            }
            if (!found) {
                System.out.println("Слово \"" + word + "\" не найдено.");
            }
        } catch (IOException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}