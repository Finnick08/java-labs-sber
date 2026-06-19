package timus.task_1001;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Long> numbers = new ArrayList<>();

        while (in.hasNextLong()) {
            numbers.add(in.nextLong());
        }

        for (int i = numbers.size() - 1; i >= 0; i--) {
            System.out.printf("%.4f%n", Math.sqrt(numbers.get(i)));
        }

        in.close();
    }
}