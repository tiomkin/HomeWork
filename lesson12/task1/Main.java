package by.courseproject.lesson12.task1;

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

        array = new String[arrayList.size()];

        fillArray(array, arrayList);

        ArrayList<String> newWordsList = new ArrayList<>();

        fillList(array, newWordsList);

        String[] newArray = new String[newWordsList.size()];

        fillArray(newArray, newWordsList);

/*        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = newWordsList.get(i);
        }*/

        printArray(newArray);

    }

    private static void fillList(String[] array, ArrayList<String> newWordsList) {
        for (int i = 0; i < array.length; i++) {
            String word = array[i];
            String newWord = "";
            char[] chars = word.toCharArray();

            newWord = deletingA(newWord, chars);

            newWordsList.add(newWord);

        }
    }

    private static String deletingA(String newWord, char[] chars) {
        for (int j = 0; j < chars.length; j++) {
            char k = chars[j];
            if (k != 'a') {
                newWord += k;
            }
        }
        return newWord;
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
