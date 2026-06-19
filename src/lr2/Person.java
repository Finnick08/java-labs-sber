package lr2;

public class Person {
    private String name;
    private int age;
    private String gender;

    // Конструктор
    public Person(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    // Геттеры
    public String getName()   { return name; }
    public int getAge()       { return age; }
    public String getGender() { return gender; }

    // Сеттеры
    public void setName(String name)     { this.name = name; }
    public void setAge(int age)          { this.age = age; }
    public void setGender(String gender) { this.gender = gender; }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + ", gender='" + gender + "'}";
    }

    public static void main(String[] args) {
        Person person = new Person("Иван", 25, "Мужской");
        System.out.println(person);

        person.setAge(26);
        System.out.println("Новый возраст: " + person.getAge());
    }
}