package lr7;
import java.io.*;

public class Example2 {
    public static void main(String[] args) {
        String filePath = "example_file.txt";
        String data = "Hello, FileStream!";

        // Запись
        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            fos.write(data.getBytes());
            System.out.println("Данные записаны в файл.");
        } catch (IOException e) {
            System.out.println("Ошибка записи: " + e.getMessage());
        }

        // Чтение
        try (FileInputStream fis = new FileInputStream(filePath)) {
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            System.out.println("Прочитано из файла: " + new String(buffer));
        } catch (IOException e) {
            System.out.println("Ошибка чтения: " + e.getMessage());
        }

        // Удаление
        File file = new File(filePath);
        if (file.delete()) {
            System.out.println("Файл удалён.");
        }
    }
}