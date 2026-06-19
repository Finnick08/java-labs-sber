package lr3;
import java.util.Scanner;

public class Task3 {
    static int[] array;
    static Scanner in = new Scanner(System.in);

    // Рекурсивный ввод
    static void inputArray(int index) {
        if (index == array.length) return;
        System.out.print("Введите элемент [" + index + "]: ");
        array[index] = in.nextInt();
        inputArray(index + 1);
    }

    // Рекурсивный вывод
    static void printArray(int index) {
        if (index == array.length) return;
        System.out.print(array[index] + " ");
        printArray(index + 1);
    }

    public static void main(String[] args) {
        System.out.println("Введите размер массива:");
        int n = in.nextInt();
        array = new int[n];

        inputArray(0);

        System.out.print("Массив: ");
        printArray(0);
        System.out.println();

        in.close();
    }
}
