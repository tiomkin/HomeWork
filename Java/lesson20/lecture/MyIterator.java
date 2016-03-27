package by.courseproject.lesson20.lecture;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Артём on 16.03.2016.
 */
public class MyIterator<T> implements Iterator<T> {

    private Map<Employee, EmployeeList<Employee>> map;

    public MyIterator(Map map) {
        this.map = map;
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public T next() {
        T employee;
        for (Map.Entry<Employee, EmployeeList<Employee>> pair : map.entrySet()) {
            Employee key = pair.getKey();
            EmployeeList<Employee> value = pair.getValue();
        }
        return employee;
    }

    @Override
    public void remove() {

    }
}
