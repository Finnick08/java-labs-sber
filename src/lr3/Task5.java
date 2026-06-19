package lr3;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class Task5 {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(0,  "zero");
        map.put(1,  "one");
        map.put(2,  "hi");
        map.put(3,  "three");
        map.put(4,  "four");
        map.put(5,  "five");
        map.put(6,  "longer");
        map.put(7,  "seventh");
        map.put(8,  "eight");
        map.put(9,  "verylongstring");

        // Найти строки, у которых ключ > 5
        System.out.println("Строки с ключом > 5:");
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            if (entry.getKey() > 5) {
                System.out.println("  " + entry.getKey() + " -> " + entry.getValue());
            }
        }

        // Если ключ = 0, вывести строки через запятую
        if (map.containsKey(0)) {
            StringJoiner sj = new StringJoiner(", ");
            for (String val : map.values()) {
                sj.add(val);
            }
            System.out.println("Все строки через запятую: " + sj);
        }

        // Перемножить все ключи, где длина строки > 5
        long product = 1;
        boolean found = false;
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            if (entry.getValue().length() > 5) {
                product *= entry.getKey();
                found = true;
                System.out.println("Ключ " + entry.getKey() + " (длина строки " + entry.getValue().length() + ")");
            }
        }
        if (found) {
            System.out.println("Произведение ключей (длина строки > 5): " + product);
        }
    }
}