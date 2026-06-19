package lr2;

// Базовый класс
class Animal {
    protected String name;
    protected int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void makeSound() {
        System.out.println(name + " издаёт звук.");
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{name='" + name + "', age=" + age + "}";
    }
}

// Собака
class Dog extends Animal {
    private String breed;

    public Dog(String name, int age, String breed) {
        super(name, age);
        this.breed = breed;
    }

    @Override
    public void makeSound() {
        System.out.println(name + " говорит: Гав!");
    }

    public String getBreed() { return breed; }
}

// Кот
class Cat extends Animal {
    private String foodType;

    public Cat(String name, int age, String foodType) {
        super(name, age);
        this.foodType = foodType;
    }

    @Override
    public void makeSound() {
        System.out.println(name + " говорит: Мяу!");
    }

    public String getFoodType() { return foodType; }
}

// Птица
class Bird extends Animal {
    private boolean canFly;

    public Bird(String name, int age, boolean canFly) {
        super(name, age);
        this.canFly = canFly;
    }

    @Override
    public void makeSound() {
        System.out.println(name + " говорит: Чирик!");
    }

    public boolean canFly() { return canFly; }
}

public class Task8Animals {
    public static void main(String[] args) {
        Animal[] animals = {
                new Dog("Рекс", 3, "Лабрадор"),
                new Cat("Мурка", 5, "Рыба"),
                new Bird("Кеша", 2, true)
        };

        for (Animal animal : animals) {
            System.out.println(animal);
            animal.makeSound();
        }
    }
}