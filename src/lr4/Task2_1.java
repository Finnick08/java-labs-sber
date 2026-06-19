package lr4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Task2_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        try {
            System.out.println("Введите размер массива:");
            int n = in.nextInt();

            int[] arr = new int[n];
            System.out.println("Введите элементы массива:");
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt(); // InputMismatchException при вводе строки
            }

            // Ищем среднее среди положительных
            long sum = 0;
            int count = 0;
            for (int val : arr) {
                if (val > 0) {
                    sum += val;
                    count++;
                }
            }

            if (count == 0) {
                // Нет положительных элементов — создаём собственное исключение
                throw new ArithmeticException("Положительные элементы отсутствуют");
            }

            // Несоответствие типа: среднее может быть дробным
            double avg = (double) sum / count;
            System.out.println("Среднее значение положительных элементов: " + avg);

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