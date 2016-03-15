package by.courseproject.lesson6.task3;

/**
 * Created by Артём on 15.03.2016.
 */
public class Circle extends Figure {

    int radius;

    public Circle(int radius){
        this.radius = radius;
    }

    @Override
    public void calculateArea(){
        double s;
        s = 3.14 * Math.pow(radius, 2);
        System.out.println("Площадь круга равна: " + s);

    }
}
