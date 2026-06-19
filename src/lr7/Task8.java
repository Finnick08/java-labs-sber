package lr7;
import java.io.*;

public class Task8 {

    static class Student implements Serializable {
        private static final long serialVersionUID = 1L;
        String name;
        int age;
        double gpa;

        Student(String name, int age, double gpa) {
            this.name = name;
            this.age = age;
            this.gpa = gpa;
        }

        @Override
        public String toString() {
            return "Student{name='" + name + "', age=" + age + ", gpa=" + gpa + "}";
        }
    }

    public static void main(String[] args) {
        String filePath = "student.ser";
        Student student = new Student("Алексей", 22, 4.8);

        // Запись в файл
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(student);
            System.out.println("Объект записан: " + student);
        } catch (IOException e) {
            System.out.println("Ошибка записи: " + e.getMessage());
        }

        // Восстановление из файла
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            Student restored = (Student) ois.readObject();
            System.out.println("Объект восстановлен: " + restored);
            System.out.println("Имя: "    + restored.name);
            System.out.println("Возраст: " + restored.age);
            System.out.println("GPA: "    + restored.gpa);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Ошибка чтения: " + e.getMessage());
        }

        new File(filePath).delete();
    }
}