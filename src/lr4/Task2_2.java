package lr4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Task2_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        try {
            System.out.println("Введите количество строк и столбцов матрицы:");
            int rows = in.nextInt();
            int cols = in.nextInt();

            int[][] matrix = new int[rows][cols];
            System.out.println("Введите элементы матрицы:");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    matrix[i][j] = in.nextInt(); // InputMismatchException при вводе строки
                }
            }

            System.out.println("Введите номер столбца (от 0 до " + (cols - 1) + "):");
            int colIndex = in.nextInt(); // InputMismatchException при вводе строки

            // ArrayIndexOutOfBoundsException если номер вне диапазона
            System.out.println("Столбец " + colIndex + ":");
            for (int i = 0; i < rows; i++) {
                System.out.println(matrix[i][colIndex]);
            }

        } catch (InputMismatchException e) {
            System.out.println("Ошибка: введена строка вместо числа. " + e);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Ошибка: столбца с таким номером не существует. " + e);
        } catch (NegativeArraySizeException e) {
            System.out.println("Ошибка: размер матрицы не может быть отрицательным. " + e);
        } finally {
            System.out.println("Программа завершена.");
            in.close();
        }
    }
}