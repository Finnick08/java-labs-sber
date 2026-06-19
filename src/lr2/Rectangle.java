package lr2;

public class Rectangle {
    private double length;
    private double width;

    // Конструктор
    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    // Геттеры и сеттеры
    public double getLength() { return length; }
    public double getWidth()  { return width; }
    public void setLength(double length) { this.length = length; }
    public void setWidth(double width)   { this.width = width; }

    // Методы вычисления
    public double getArea()      { return length * width; }
    public double getPerimeter() { return 2 * (length + width); }

    @Override
    public String toString() {
        return "Rectangle{length=" + length + ", width=" + width + "}";
    }

    public static void main(String[] args) {
        Rectangle rect = new Rectangle(5.0, 3.0);
        System.out.println(rect);
        System.out.println("Площадь: " + rect.getArea());
        System.out.println("Периметр: " + rect.getPerimeter());
    }
}