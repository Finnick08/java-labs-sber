package timus.task_1086;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 15000-е простое число примерно равно 163841
        // возьмём с запасом
        int LIMIT = 200000;
        boolean[] isComposite = new boolean[LIMIT + 1];
        isComposite[0] = isComposite[1] = true;

        // Решето Эратосфена
        for (int i = 2; i * i <= LIMIT; i++) {
            if (!isComposite[i]) {
                for (int j = i * i; j <= LIMIT; j += i) {
                    isComposite[j] = true;
                }
            }
        }

        // Собираем простые числа в список
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= LIMIT; i++) {
            if (!isComposite[i]) primes.add(i);
        }

        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k; i++) {
            int n = in.nextInt();
            sb.append(primes.get(n - 1)).append("\n");
        }
        System.out.print(sb);
        in.close();
    }
}