package lr7;
import java.io.*;

public class Example6 {
    public static void main(String[] args) {
        String filePath = "example_file.txt";

        // Запись через PrintWriter
        try (PrintWriter pw = new PrintWriter(new FileWriter(filePath))) {
            pw.println("Первая строка");
            pw.println("Вторая строка");
            pw.print("Без переноса");
            System.out.println("Данные записаны через PrintWriter.");
        } catch (IOException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        // Чтение и вывод через PrintWriter в консоль
        try (
                BufferedReader br = new BufferedReader(new FileReader(filePath));
                PrintWriter pw = new PrintWriter(System.out)
        ) {
            String line;
            while ((line = br.readLine()) != null) {
                pw.println("Из файла: " + line);
            }
            pw.flush();
        } catch (IOException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        new File(filePath).delete();
    }
}