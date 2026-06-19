package lr8;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import java.io.*;
import java.util.Scanner;

public class ExcelTask {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Введите путь к Excel файлу (.xlsx):");
            String path = scanner.nextLine().trim();

            File file = new File(path);
            if (!file.exists()) {
                System.out.println("Ошибка: файл не найден — " + path);
                System.out.println("Проверьте путь и попробуйте снова.\n");
                continue;
            }
            if (!path.endsWith(".xlsx")) {
                System.out.println("Ошибка: поддерживается только формат .xlsx\n");
                continue;
            }

            System.out.println("Введите название листа:");
            String sheetName = scanner.nextLine().trim();

            try (XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(file))) {
                Sheet sheet = workbook.getSheet(sheetName);
                if (sheet == null) {
                    System.out.println("Ошибка: лист \"" + sheetName + "\" не найден.");
                    System.out.println("Доступные листы:");
                    for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
                        System.out.println("  - " + workbook.getSheetName(i));
                    }
                    System.out.println();
                    continue;
                }

                System.out.println("Содержимое листа \"" + sheetName + "\":");
                for (Row row : sheet) {
                    for (Cell cell : row) {
                        System.out.print(cell.toString() + "\t");
                    }
                    System.out.println();
                }
                break;

            } catch (IOException e) {
                System.out.println("Ошибка чтения файла: " + e.getMessage());
                System.out.println("Убедитесь, что файл не повреждён и не открыт в другой программе.\n");
            }
        }
        scanner.close();
    }
}