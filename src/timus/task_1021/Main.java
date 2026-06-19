import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n1 = in.nextInt();
        int[] a = new int[n1];
        for (int i = 0; i < n1; i++) a[i] = in.nextInt();

        int n2 = in.nextInt();
        int[] b = new int[n2];
        for (int i = 0; i < n2; i++) b[i] = in.nextInt();

        in.close();

        // a — по возрастанию, b — по убыванию
        // два указателя: i с начала a (минимум), j с начала b (максимум)
        int i = 0, j = 0;
        boolean found = false;

        while (i < n1 && j < n2) {
            int sum = a[i] + b[j];
            if (sum == 10000) {
                found = true;
                break;
            } else if (sum < 10000) {
                i++; // нужна большая сумма — берём большее из a
            } else {
                j++; // нужна меньшая сумма — берём меньшее из b
            }
        }

        System.out.println(found ? "YES" : "NO");
    }
}