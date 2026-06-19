package lr5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Examples {

    // Пример 1: только чётные числа из массива
    static int[] filterEven(int[] arr) {
        return Arrays.stream(arr)
                .filter(n -> n % 2 == 0)
                .toArray();
    }

    // Пример 2: общие элементы двух массивов
    static int[] intersection(int[] a, int[] b) {
        return Arrays.stream(a)
                .filter(x -> Arrays.stream(b).anyMatch(y -> y == x))
                .toArray();
    }

    // Пример 3: строки, начинающиеся с большой буквы
    static List<String> startsWithUpperCase(List<String> list) {
        return list.stream()
                .filter(s -> !s.isEmpty() && Character.isUpperCase(s.charAt(0)))
                .collect(Collectors.toList());
    }

    // Пример 4: квадраты чисел
    static List<Integer> squares(List<Integer> list) {
        return list.stream()
                .map(n -> n * n)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        System.out.println("=== Пример 1: чётные числа ===");
        System.out.println(Arrays.toString(filterEven(new int[]{1, 2, 3, 4, 5, 6})));

        System.out.println("=== Пример 2: пересечение массивов ===");
        System.out.println(Arrays.toString(intersection(
                new int[]{1, 2, 3, 4, 5},
                new int[]{3, 4, 5, 6, 7})));

        System.out.println("=== Пример 3: строки с большой буквы ===");
        System.out.println(startsWithUpperCase(
                List.of("Hello", "world", "Java", "stream")));

        System.out.println("=== Пример 4: квадраты чисел ===");
        System.out.println(squares(List.of(1, 2, 3, 4, 5)));
    }
}