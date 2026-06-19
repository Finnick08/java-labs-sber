package lr2;

// Базовый класс
abstract class ShapeBase {
    public abstract double getArea();
    public abstract double getPerimeter();

    @Override
    public String toString() {
        return getClass().getSimpleName()
                + " | Площадь: " + String.format("%.2f", getArea())
                + " | Периметр: " + String.format("%.2f", getPerimeter());
    }
}

class CircleShape extends ShapeBase {
    private double radius;
    public CircleShape(double radius) { this.radius = radius; }

    @Override
    public double getArea()      { return Math.PI * radius * radius; }

    @Override
    public double getPerimeter() { return 2 * Math.PI * radius; }
}

class SquareShape extends ShapeBase {
    private double side;
    public SquareShape(double side) { this.side = side; }

    @Override
    public double getArea()      { return side * side; }

    @Override
    public double getPerimeter() { return 4 * side; }
}

class TriangleShape extends ShapeBase {
    private double a, b, c;
    public TriangleShape(double a, double b, double c) {
        this.a = a; this.b = b; this.c = c;
    }

    @Override
    public double getArea() {
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    @Override
    public double getPerimeter() { return a + b + c; }
}

public class Task8Shapes {
    public static void main(String[] args) {
        ShapeBase[] shapes = {
                new CircleShape(7),
                new SquareShape(6),
                new TriangleShape(3, 4, 5)
        };

        for (ShapeBase shape : shapes) {
            System.out.println(shape);
        }
    }
}