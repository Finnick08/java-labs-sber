package lr3;

public class Task1 {

    // Пример 1: последовательность x = 2*x+1 пока x < 20
    static void example1(int x) {
        System.out.println(x);
        int next = 2 * x + 1;
        if (next < 20) {
            example1(next);
        }
    }

    // Пример 2: вывод в обратном порядке
    static void example2(int x) {
        int next = 2 * x + 1;
        if (next < 20) {
            example2(next);
        }
        System.out.println(x);
    }

    // Пример 3: вывод до и после рекурсивного вызова
    static void example3(int x) {
        System.out.println("Before: " + x);
        int next = 2 * x + 1;
        if (next < 20) {
            example3(next);
        }
        System.out.println("After: " + x);
    }

    // Пример 4: факториал
    static long factorial(int n) {
        if (n <= 1) return 1;
        return n * factorial(n - 1);
    }

    // Пример 5: числа Фибоначчи + дерево вызовов
    static int fibonacci(int n, int depth) {
        String indent = "  ".repeat(depth);
        System.out.println(indent + "fib(" + n + ")");
        if (n <= 1) return n;
        int result = fibonacci(n - 1, depth + 1) + fibonacci(n - 2, depth + 1);
        System.out.println(indent + "fib(" + n + ") = " + result);
        return result;
    }

    public static void main(String[] args) {
        System.out.println("Пример 1");
        example1(0);

        System.out.println("Пример 2 (обратный)");
        example2(0);

        System.out.println("Пример 3 (до и после)");
        example3(0);

        System.out.println("Пример 4 (факториал 5)");
        System.out.println("5! = " + factorial(5));

        System.out.println("Пример 5 (Фибоначчи 5, дерево вызовов)");
        int result = fibonacci(5, 0);
        System.out.println("fib(5) = " + result);
    }
}