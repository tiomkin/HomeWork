package by.courseproject.lesson20.lecture;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Артём on 16.03.2016.
 */
public class MainEmployee {

    public static void main(String[] args) {
        Employee director = new Employee("John Stivenson");
        Employee headOfDepartment1 = new Employee("Mark Zukerberg");
        Employee headOfDepartment2 = new Employee("Serge Stivenson");

        EmployeeList<Employee> department1 = new EmployeeList<Employee>();
        Employee employee1 = new Employee("Tim Kuk");
        Employee employee2 = new Employee("Debora Stivens");
        department1.add(employee1);
        department1.add(employee2);

        EmployeeList<Employee> department2 = new EmployeeList<Employee>();
        department2.add(new Employee("Greg Wolf"));
        department2.add(new Employee("Tom Soyer"));
        department2.add(new Employee("Kate Moskin"));

        Map<Employee, EmployeeList<Employee>> allDepartments = new HashMap<Employee, EmployeeList<Employee>>();
        allDepartments.put(headOfDepartment1, department1);
        allDepartments.put(headOfDepartment2, department2);

        for (Map.Entry<Employee, EmployeeList<Employee>> pair : allDepartments.entrySet()) {
            Employee key = pair.getKey();
            EmployeeList value = pair.getValue();
            System.out.println(key);
            while (value.hasNext()) {
                Object employee = value.next();
                System.out.println(employee);
            }
        }


    }





}
