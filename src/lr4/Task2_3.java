package lr4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Task2_3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        try {
            System.out.println("Введите размер массива:");
            int n = in.nextInt();

            byte[] arr = new byte[n];
            System.out.println("Введите элементы массива (от -128 до 127):");
            for (int i = 0; i < n; i++) {
                int val = in.nextInt(); // InputMismatchException при вводе строки

                // Проверка диапазона типа byte (-128..127)
                if (val < Byte.MIN_VALUE || val > Byte.MAX_VALUE) {
                    throw new ArithmeticException(
                            "Значение " + val + " выходит за диапазон типа byte [-128, 127]"
                    );
                }
                arr[i] = (byte) val;
            }

            // Сумма может выйти за диапазон byte — используем int
            int sum = 0;
            for (byte val : arr) {
                sum += val;
                // Проверка переполнения byte при накоплении суммы
                if (sum < Byte.MIN_VALUE || sum > Byte.MAX_VALUE) {
                    throw new ArithmeticException(
                            "Сумма " + sum + " вышла за границы диапазона типа byte"
                    );
                }
            }

            System.out.println("Сумма элементов: " + sum);

        } catch (InputMismatchException e) {
            System.out.println("Ошибка: введена строка вместо числа. " + e);
        } catch (ArithmeticException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } catch (NegativeArraySizeException e) {
            System.out.println("Ошибка: размер массива не может быть отрицательным. " + e);
        } finally {
            System.out.println("Программа завершена.");
            in.close();
        }
    }
}