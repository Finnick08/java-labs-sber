package lr2;

// Интерфейс
interface Shape {
    double getArea();
    double getPerimeter();
}

// Круг
class Circle implements Shape {
    private double radius;

    public Circle(double radius) { this.radius = radius; }

    @Override
    public double getArea()      { return Math.PI * radius * radius; }

    @Override
    public double getPerimeter() { return 2 * Math.PI * radius; }

    @Override
    public String toString() { return "Circle(radius=" + radius + ")"; }
}

// Квадрат
class Square implements Shape {
    private double side;

    public Square(double side) { this.side = side; }

    @Override
    public double getArea()      { return side * side; }

    @Override
    public double getPerimeter() { return 4 * side; }

    @Override
    public String toString() { return "Square(side=" + side + ")"; }
}

// Треугольник (прямоугольный, с катетами a, b)
class Triangle implements Shape {
    private double a, b, c;

    public Triangle(double a, double b, double c) {
        this.a = a; this.b = b; this.c = c;
    }

    @Override
    public double getArea() {
        // Формула Герона
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    @Override
    public double getPerimeter() { return a + b + c; }

    @Override
    public String toString() { return "Triangle(a=" + a + ", b=" + b + ", c=" + c + ")"; }
}

// Главный класс
public class Task6 {
    public static void main(String[] args) {
        Shape[] shapes = {
                new Circle(5),
                new Square(4),
                new Triangle(3, 4, 5)
        };

        for (Shape shape : shapes) {
            System.out.println(shape);
            System.out.printf("  Площадь: %.2f%n", shape.getArea());
            System.out.printf("  Периметр: %.2f%n", shape.getPerimeter());
        }
    }
}