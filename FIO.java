package by.courseproject.lesson12.task3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by Администратор on 16.03.2016.
 */
public class FIO {

    String surname, name, middlename;

    public FIO(String surname, String name, String middlename) {
        this.surname = surname;
        this.name = name;
        this.middlename = middlename;
    }

    @Override
    public String toString() {
        String s = surname + " " + name + " " + middlename;
        return s;
    }

    public static void main(String[] args) throws IOException {
        FIO[] man = new FIO[4];
        FIO[] woman = new FIO[4];

        man[0] = new FIO("Ivanov", "Ivan", "Ivanovich");
        man[1] = new FIO("Petrov", "Petr", "Petrovich");
        man[2] = new FIO("Sidorov", "Fedor", "fedorovich");
        man[3] = new FIO("Semenov", "Semen", "Semenovich");

        woman[0] = new FIO("Ivanova", "Anna", "Ivanovna");
        woman[1] = new FIO("Petrova", "Raisa", "Fedorovna");
        woman[2] = new FIO("Sidorova", "Ekaterina", "Andreevna");
        woman[3] = new FIO("Semenova", "Marina", "Viktorovna");

        Map<String, FIO[]> map = new HashMap<String, FIO[]>();

        map.put("man", man);
        map.put("woman", woman);

        System.out.println("Введите man или woman, чтобы получить случайное мужское или женское ФИО: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //Для выхода из программы ввести exit
        while (true) {
            String s = reader.readLine();
            if (s.equals("exit")) break;
            if (!(s.equals("man")) && !(s.equals("woman"))) System.out.println("Необходимо ввести man или woman!");
            else {
                if (s.equals("man")) show("man", map);
                else if (s.equals("woman")) show("woman", map);
                }
            }
        }

        private static void show(String s, Map map) {
            Map<String, FIO[]> map1 = map;
            ArrayList<FIO> man = new ArrayList<FIO>();
            ArrayList<FIO> woman = new ArrayList<FIO>();
            for (Map.Entry<String, FIO[]> pair : map1.entrySet()) {
                String key = pair.getKey();
                FIO[] value = pair.getValue();
                for (int i = 0; i < value.length; i++) {
                    if (key.equals("man")) man.add(value[i]);
                    else if (key.equals("woman")) woman.add(value[i]);
                }
            }


            String s1 = s;
            Random random = new Random();
            int i = random.nextInt(4);
            if (s1.equals("man")) System.out.println(man.get(i));
            else if (s1.equals("woman")) System.out.println(woman.get(i));
            //System.out.println(i);
        }
    }



