package lr5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Tasks {

    // Задание 1: только чётные числа из массива
    static int[] filterEven(int[] arr) {
        return Arrays.stream(arr)
                .filter(n -> n % 2 == 0)
                .toArray();
    }

    // Задание 2: общие элементы двух массивов
    static int[] intersection(int[] a, int[] b) {
        return Arrays.stream(a)
                .filter(x -> Arrays.stream(b).anyMatch(y -> y == x))
                .toArray();
    }

    // Задание 3: строки, начинающиеся с большой буквы
    static List<String> startsWithUpperCase(List<String> list) {
        return list.stream()
                .filter(s -> !s.isEmpty() && Character.isUpperCase(s.charAt(0)))
                .collect(Collectors.toList());
    }

    // Задание 4: квадраты чисел
    static List<Integer> squares(List<Integer> list) {
        return list.stream()
                .map(n -> n * n)
                .collect(Collectors.toList());
    }

    // Задание 5: строки, содержащие заданную подстроку
    static List<String> containsSubstring(List<String> list, String sub) {
        return list.stream()
                .filter(s -> s.contains(sub))
                .collect(Collectors.toList());
    }

    // Задание 6: числа, делящиеся на заданное без остатка
    static List<Integer> divisibleBy(List<Integer> list, int divisor) {
        return list.stream()
                .filter(n -> n % divisor == 0)
                .collect(Collectors.toList());
    }

    // Задание 7: строки длиннее заданного значения
    static List<String> longerThan(List<String> list, int minLength) {
        return list.stream()
                .filter(s -> s.length() > minLength)
                .collect(Collectors.toList());
    }

    // Задание 8: числа больше заданного значения
    static List<Integer> greaterThan(List<Integer> list, int threshold) {
        return list.stream()
                .filter(n -> n > threshold)
                .collect(Collectors.toList());
    }

    // Задание 9: строки, содержащие только буквы (без цифр и символов)
    static List<String> onlyLetters(List<String> list) {
        return list.stream()
                .filter(s -> s.matches("[a-zA-Zа-яА-ЯёЁ]+"))
                .collect(Collectors.toList());
    }

    // Задание 10: числа меньше заданного значения
    static List<Integer> lessThan(List<Integer> list, int threshold) {
        return list.stream()
                .filter(n -> n < threshold)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        System.out.println("=== Задание 1: чётные числа ===");
        System.out.println(Arrays.toString(
                filterEven(new int[]{1, 2, 3, 4, 5, 6, 7, 8})));

        System.out.println("=== Задание 2: пересечение массивов ===");
        System.out.println(Arrays.toString(
                intersection(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 6, 7})));

        System.out.println("=== Задание 3: строки с большой буквы ===");
        System.out.println(startsWithUpperCase(
                List.of("Hello", "world", "Java", "stream", "API")));

        System.out.println("=== Задание 4: квадраты чисел ===");
        System.out.println(squares(List.of(1, 2, 3, 4, 5)));

        System.out.println("=== Задание 5: строки, содержащие 'ava' ===");
        System.out.println(containsSubstring(
                List.of("Java", "Python", "JavaScript", "Kotlin"), "ava"));

        System.out.println("=== Задание 6: числа, делящиеся на 3 ===");
        System.out.println(divisibleBy(
                List.of(1, 2, 3, 6, 7, 9, 12, 14), 3));

        System.out.println("=== Задание 7: строки длиннее 4 символов ===");
        System.out.println(longerThan(
                List.of("Hi", "Java", "Stream", "API", "Lambda"), 4));

        System.out.println("=== Задание 8: числа больше 5 ===");
        System.out.println(greaterThan(
                List.of(1, 3, 5, 7, 9, 11), 5));

        System.out.println("=== Задание 9: строки только из букв ===");
        System.out.println(onlyLetters(
                List.of("Hello", "World2", "Java!", "Stream", "API123")));

        System.out.println("=== Задание 10: числа меньше 5 ===");
        System.out.println(lessThan(
                List.of(1, 3, 5, 7, 9, 11), 5));
    }
}