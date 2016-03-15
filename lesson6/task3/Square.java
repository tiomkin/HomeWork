package by.courseproject.lesson6.task3;

/**
 * Created by Артём on 15.03.2016.
 */
public class Square extends Figure {
    double a;

    public Square(int a) {
        this.a = (double)a;
    }

    @Override
    public void calculateArea() {
        double s = Math.pow(a, 2);
        System.out.println("Площадь квадрата равна: " + s);

    }
}
