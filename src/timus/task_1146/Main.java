package timus.task_1146;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());

        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int maxSum = Integer.MIN_VALUE;

        // Перебираем все пары строк
        for (int r1 = 0; r1 < n; r1++) {
            int[] col = new int[n];
            for (int r2 = r1; r2 < n; r2++) {
                // Добавляем строку r2 к столбцовым суммам
                for (int c = 0; c < n; c++) {
                    col[c] += a[r2][c];
                }
                // Алгоритм Кадане для массива col
                int cur = 0;
                for (int c = 0; c < n; c++) {
                    cur += col[c];
                    if (cur > maxSum) maxSum = cur;
                    if (cur < 0) cur = 0;
                }
            }
        }

        System.out.println(maxSum);
    }
}