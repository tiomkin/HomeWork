package by.courseproject.lesson12.task2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by Администратор on 18.03.2016.
 */
public class Main {

    public static void main(String[] args) throws IOException {

        String[] array;
        String input;
        ArrayList<String> arrayList = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            input = reader.readLine();
            if (input.equals("exit")) break;
            else {
                arrayList.add(input);
            }
        }

        changeList(arrayList);

        array = new String[arrayList.size()];

        fillArray(array, arrayList);

        printArray(array);

    }

    private static void changeList(ArrayList<String> arrayList) {
        for (int i = 0; i < arrayList.size() - 1; i++) {
            for (int j = i+1; j < arrayList.size(); j++) {
                if (arrayList.get(j).equals(arrayList.get(i))) arrayList.remove(j);
            }

        }
    }

    private static void fillArray(String[] array, ArrayList<String> arrayList) {
        for (int i = 0; i < arrayList.size(); i++) {

            array[i] = arrayList.get(i);

        }
    }

    private static void printArray(String[] newArray) {
        for (int i = 0; i < newArray.length; i++) {
            System.out.println(newArray[i]);
        }
    }
}
