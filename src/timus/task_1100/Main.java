package timus.task_1100;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());

        final int[] id = new int[n];
        final int[] m  = new int[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            id[i] = Integer.parseInt(st.nextToken());
            m[i]  = Integer.parseInt(st.nextToken());
        }

        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) idx[i] = i;

        Arrays.sort(idx, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return m[b] - m[a];
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int i : idx) {
            sb.append(id[i]).append(' ').append(m[i]).append('\n');
        }
        System.out.print(sb);
    }
}