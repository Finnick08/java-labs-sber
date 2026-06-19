package lr7;
import java.io.*;
import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите путь к исходному файлу:");
        String srcPath = scanner.nextLine();
        System.out.println("Введите путь к файлу назначения:");
        String dstPath = scanner.nextLine();
        scanner.close();

        try (
                BufferedReader br = new BufferedReader(new FileReader(srcPath));
                BufferedWriter bw = new BufferedWriter(new FileWriter(dstPath))
        ) {
            String line;
            while ((line = br.readLine()) != null) {
                bw.write(line);
                bw.newLine();
            }
            System.out.println("Файл успешно скопирован в " + dstPath);
        } catch (IOException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}