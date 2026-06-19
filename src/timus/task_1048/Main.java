package timus.task_1048;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());

        // Храним только суммы пар цифр — один массив вместо двух
        int[] sums = new int[n];
        for (int i = 0; i < n; i++) {
            String[] parts = br.readLine().trim().split(" ");
            sums[i] = Integer.parseInt(parts[0]) + Integer.parseInt(parts[1]);
        }

        // Обрабатываем перенос с конца
        int carry = 0;
        for (int i = n - 1; i >= 0; i--) {
            sums[i] += carry;
            carry = sums[i] / 10;
            sums[i] %= 10;
        }

        // Выводим ровно N цифр через PrintWriter для скорости
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            sb.append(sums[i]);
        }
        pw.println(sb);
        pw.flush();
    }
}