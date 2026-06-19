package timus.task_1083;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String bangs = in.next(); // строка из '!'
        in.close();

        int k = bangs.length(); // количество '!'

        long result = n;
        int cur = n - k;
        while (cur > 0) {
            result *= cur;
            cur -= k;
        }

        System.out.println(result);
    }
}