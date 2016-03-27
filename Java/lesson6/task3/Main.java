package by.courseproject.lesson6.task3;

import java.util.ArrayList;

/**
 * Created by Артём on 15.03.2016.
 */
public class Main {

    public static void main(String[] args) {
        Figure circle = new Circle(4);
        Figure triangle = new Triangle(3, 4, 5);
        Figure square = new Square(3);
        Figure rectangle = new Rectangle(10, 12);

        ArrayList<Figure> figures = new ArrayList<Figure>();
        figures.add(circle);
        figures.add(triangle);
        figures.add(square);
        figures.add(rectangle);

        for (Figure figure : figures){
            figure.calculateArea();

        }
    }
}
