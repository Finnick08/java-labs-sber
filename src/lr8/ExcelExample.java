package lr8;
import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;
import java.io.*;

public class ExcelExample {

    static final String FILE_PATH = "products.xlsx";

    // Создание Excel файла
    static void createExcel() throws Exception {
        try (XSSFWorkbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Товары");

            // Заголовок
            Row header = sheet.createRow(0);
            header.createCell(0).setCellValue("Название");
            header.createCell(1).setCellValue("Характеристика");
            header.createCell(2).setCellValue("Стоимость");

            // Данные
            String[][] data = {
                    {"Книга",     "Java Programming, 500 стр.", "1500"},
                    {"Компьютер", "Intel i7, 16GB RAM",         "75000"}
            };
            for (int i = 0; i < data.length; i++) {
                Row row = sheet.createRow(i + 1);
                for (int j = 0; j < data[i].length; j++) {
                    row.createCell(j).setCellValue(data[i][j]);
                }
            }

            try (FileOutputStream fos = new FileOutputStream(FILE_PATH)) {
                workbook.write(fos);
            }
            System.out.println("Excel создан: " + FILE_PATH);
        }
    }

    // Чтение Excel файла
    static void readExcel() throws Exception {
        try (XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(FILE_PATH))) {
            Sheet sheet = workbook.getSheet("Товары");
            for (Row row : sheet) {
                for (Cell cell : row) {
                    System.out.print(cell.toString() + "\t");
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        createExcel();
        readExcel();
    }
}