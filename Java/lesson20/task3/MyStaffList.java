package by.courseproject.lesson20.task3;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Администратор on 18.03.2016.
 */
public class MyStaffList<T> implements Iterator<T> {

    T list1;
    T list2;
    int length;

    public MyStaffList() {}

    public void add(T element) {
        this.length++;
    }

    public int size() {
        return length;
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public T next() {
        return null;
    }

    @Override
    public void remove() {

    }
}
