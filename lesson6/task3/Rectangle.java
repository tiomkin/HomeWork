package by.courseproject.lesson6.task3;

/**
 * Created by Артём on 15.03.2016.
 */
public class Rectangle extends Figure {

    double a, b;

    public Rectangle(int a, int b) {
        this.a = (double)a;
        this.b = (double)b;
    }

    @Override
    public void calculateArea() {
        double s = a * b;
        System.out.println("Площадь прямоугольника равна: " + s);

    }
}
