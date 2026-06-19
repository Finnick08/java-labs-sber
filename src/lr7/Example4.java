package lr7;
import java.io.*;

public class Example4 {
    public static void main(String[] args) {
        String filePath = "example_file.txt";
        String data = "Hello, BufferedWriter!";

        // Запись с буферизацией
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            bw.write(data);
            System.out.println("Данные записаны с буферизацией.");
        } catch (IOException e) {
            System.out.println("Ошибка записи: " + e.getMessage());
        }

        // Чтение с буферизацией
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println("Прочитано: " + line);
            }
        } catch (IOException e) {
            System.out.println("Ошибка чтения: " + e.getMessage());
        }

        new File(filePath).delete();
        System.out.println("Файл удалён.");
    }
}