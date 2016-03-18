package by.courseproject.lesson20.task3;

/**
 * Created by Администратор on 18.03.2016.
 */
public class MyStaff {

    String name, surname;

    public MyStaff(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public void show(MyStaff myStaff) {
        System.out.println("Фамилия: " + myStaff.surname + " " + "Имя: " + myStaff.name);
    }

    public void show(MyStaffList myStaffList) {
        for (int i = 0; i < myStaffList.size(); i++) {

        }
    }
}
