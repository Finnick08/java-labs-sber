package lr7;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class Example5 {
    public static void main(String[] args) {
        String inputPath  = "input.txt";
        String outputPath = "output.txt";

        // Создадим входной файл для примера
        try (FileWriter fw = new FileWriter(inputPath)) {
            fw.write("hello world\njava io example\n");
        } catch (IOException e) {
            System.out.println("Ошибка создания input.txt: " + e.getMessage());
            return;
        }

        // Чтение из input.txt и запись в output.txt в верхнем регистре
        try (
                BufferedReader br = new BufferedReader(
                        new InputStreamReader(new FileInputStream(inputPath), StandardCharsets.UTF_8));
                BufferedWriter bw = new BufferedWriter(
                        new OutputStreamWriter(new FileOutputStream(outputPath), StandardCharsets.UTF_8))
        ) {
            String line;
            while ((line = br.readLine()) != null) {
                bw.write(line.toUpperCase());
                bw.newLine();
            }
            System.out.println("Данные преобразованы и записаны в " + outputPath);
        } catch (IOException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        new File(inputPath).delete();
        new File(outputPath).delete();
    }
}