package by.courseproject.lesson20.lecture;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by Артём on 16.03.2016.
 */
public class EmployeeList<T> implements Iterator<T> {
    private List<T> list1;
    private List<T> list2;
    private Map<K, V> map;
    private int currentIndex = 0;

    public EmployeeList() {
        super();
    }

    public void add(T value) {
        list1.add(value);
    }

    @Override
    public boolean hasNext() {
        if (list1.size() + list2.size() < currentIndex) {
            return true;
        }
        return false;
    }

    @Override
    public T next() {
        T user;

        if (list1.size() > currentIndex) {
            return list1.get(currentIndex);
            currentIndex++;
        }
        else {
            if (currentIndex == list1.size()) {
                return list1.get(currentIndex);
            }

        }
        user = list2.get(currentIndex);
        currentIndex++;
        return user;
    }

    @Override
    public void remove() {

    }
}
