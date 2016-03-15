package by.courseproject.lesson6.task3;

/**
 * Created by Артём on 15.03.2016.
 */
public class Triangle extends Figure {
    int a, b, c;

    public Triangle(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public void calculateArea() {
        double p = (a + b + c) / 2;
        double s = Math.sqrt(p * (p - a) * (p - b) * (p - c));
        System.out.println("Площадь треугольника равна: " + s);

    }
}
