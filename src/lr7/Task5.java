package lr7;
import java.io.File;
import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите название файла:");
        String filePath = scanner.nextLine();
        scanner.close();

        File file = new File(filePath);

        if (file.exists() && file.isFile()) {
            System.out.println("Размер файла: " + file.length() + " байт");
        } else {
            System.out.println("Файл не найден: " + filePath);
        }
    }
}