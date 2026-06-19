package lr7;
import java.io.*;

public class Example3 {
    public static void main(String[] args) {
        String filePath = "example_file.txt";
        String data = "Hello, FileWriter!";

        // Запись
        try (FileWriter fw = new FileWriter(filePath)) {
            fw.write(data);
            System.out.println("Данные записаны.");
        } catch (IOException e) {
            System.out.println("Ошибка записи: " + e.getMessage());
        }

        // Чтение
        try (FileReader fr = new FileReader(filePath)) {
            char[] buffer = new char[1024];
            int count = fr.read(buffer);
            System.out.println("Прочитано: " + new String(buffer, 0, count));
        } catch (IOException e) {
            System.out.println("Ошибка чтения: " + e.getMessage());
        }

        new File(filePath).delete();
        System.out.println("Файл удалён.");
    }
}