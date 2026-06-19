package lr7;
import java.io.*;

public class Example7 {

    static class Person implements Serializable {
        private static final long serialVersionUID = 1L;
        String name;
        int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{name='" + name + "', age=" + age + "}";
        }
    }

    public static void main(String[] args) {
        String filePath = "person.ser";
        Person person = new Person("Иван", 30);

        // Сериализация
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(person);
            System.out.println("Объект сериализован: " + person);
        } catch (IOException e) {
            System.out.println("Ошибка сериализации: " + e.getMessage());
        }

        // Десериализация
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            Person restored = (Person) ois.readObject();
            System.out.println("Объект восстановлен: " + restored);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Ошибка десериализации: " + e.getMessage());
        }

        new File(filePath).delete();
    }
}