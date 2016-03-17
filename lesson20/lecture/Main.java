package by.courseproject.lesson20.lecture;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Артём on 16.03.2016.
 */
public class Main {
    public static void main(String[] args) {
/*        List<Integer> list = new ArrayList<Integer>();

        MyArrayList<String> myArrayList = new MyArrayList<String>();
        myArrayList.add("hello");

        System.out.println(myArrayList.get(0));

        MyArrayList<Integer> myArrayListInt = new MyArrayList<Integer>();
        myArrayListInt.add(3);
        System.out.println(myArrayListInt.get(0));*/
        ArrayList<String> arrayList = new ArrayList<String>();
        test(arrayList);
        test(new ArrayList<Integer>());
    }

    public static <T extends List> T test(T value) {



        return value;
    }

}
