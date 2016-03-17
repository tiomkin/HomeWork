package by.courseproject.lesson20.lecture;

import java.util.List;

/**
 * Created by Артём on 16.03.2016.
 */
public class MyArrayList<T> {

    private List<T> data;
    //private int lastIndex = 0;

    public MyArrayList() {
        super();

    }

    public void add(T value) {
        data.add(value);
        //lastIndex++;
    }

    public T get(int i) {
        return data.get(i);
    }
}
