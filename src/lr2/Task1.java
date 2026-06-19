package lr2;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Task1 {
    public static void main(String[] args) {
        int n = 10;
        int[] array = new int[n];
        Random random = new Random();

        // Заполнение массива случайными числами от 0 до 99
        for (int i = 0; i < n; i++) {
            array[i] = random.nextInt(100);
        }

        // Вывод массива
        System.out.print("Массив: ");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();

        // Поиск минимального элемента
        int min = array[0];
        for (int num : array) {
            if (num < min) min = num;
        }

        // Поиск всех индексов минимума
        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (array[i] == min) indices.add(i);
        }

        System.out.println("Минимальное значение: " + min);
        System.out.println("Индексы: " + indices);
    }
}
