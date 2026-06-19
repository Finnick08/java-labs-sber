package lr2;
import java.util.Scanner;

public class Task3 {

    public static String encrypt(String text, int key) {
        StringBuilder result = new StringBuilder();
        for (char c : text.toCharArray()) {
            result.append((char)(c + key));
        }
        return result.toString();
    }

    public static String decrypt(String text, int key) {
        StringBuilder result = new StringBuilder();
        for (char c : text.toCharArray()) {
            result.append((char)(c - key));
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите текст для шифрования:");
        String text = in.nextLine();

        System.out.println("Введите ключ:");
        int key = in.nextInt();
        in.nextLine();

        String encrypted = encrypt(text, key);
        System.out.println("Текст после преобразования: " + encrypted);

        while (true) {
            System.out.println("Выполнить обратное преобразование? (y/n)");
            String answer = in.nextLine().trim();

            if (answer.equals("y")) {
                String decrypted = decrypt(encrypted, key);
                System.out.println("Текст после обратного преобразования: " + decrypted);
                break;
            } else if (answer.equals("n")) {
                System.out.println("До свидания!");
                break;
            } else {
                System.out.println("Введите корректный ответ");
            }
        }

        in.close();
    }
}