package by.courseproject.lesson5.task2;

import java.util.ArrayList;

/**
 * Created by Администратор on 18.03.2016.
 */
public class Main {

    public static void main(String[] args) {
        Tv tv1 = new Tv();
        LcdTv tv2 = new LcdTv();

        ArrayList<Appliances> tv = new ArrayList<>();
        tv.add(tv1);
        tv.add(tv2);

        for (Appliances s : tv) {
            s.on();
        }
    }
}
