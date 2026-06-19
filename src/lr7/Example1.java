package lr7;
import java.io.File;
import java.io.IOException;

public class Example1 {
    public static void main(String[] args) throws IOException {
        File folder = new File("src/lr7/example1/example_folder");

        if (!folder.exists()) {
            folder.mkdirs();
            System.out.println("Папка создана: " + folder.getPath());
        } else {
            System.out.println("Папка уже существует.");
        }

        File file = new File(folder, "example_file.txt");

        if (!file.exists()) {
            file.createNewFile();
            System.out.println("Файл создан: " + file.getPath());
        } else {
            System.out.println("Файл уже существует.");
        }

        if (file.delete()) {
            System.out.println("Файл удалён.");
        }

        if (folder.delete()) {
            System.out.println("Папка удалена.");
        }
    }
}