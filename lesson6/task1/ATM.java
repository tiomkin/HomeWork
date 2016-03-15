package by.courseproject.lesson6.task1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Артём on 14.03.2016.
 */
public class ATM {
    public Map<Integer, Integer> banknotes = new HashMap<Integer, Integer>();

    public ATM(int numOfBanknotesBy20, int numOfBanknotesBy50, int numOfBanknotesBy100) {
        banknotes.put(20, numOfBanknotesBy20);
        banknotes.put(50, numOfBanknotesBy50);
        banknotes.put(100, numOfBanknotesBy100);

    }

    public static void main(String[] args) {
        ATM atm = new ATM(1, 5, 10);

        atm.addCash(20, 10);
        atm.addCash(50, 11);
        atm.addCash(100, 7);
        atm.addCash(20, 1);

        System.out.println(withdrawCash(atm, 300));
    }

    //Указываем номинал банкноты и количество данных банкнот
    public void addCash(int banknote, int sumOfMoney){
        switch (banknote) {
            case 20:
                banknotes.put(20, (banknotes.get(20) + sumOfMoney));
                break;
            case 50:
                banknotes.put(50, (banknotes.get(50) + sumOfMoney));
                break;
            case 100:
                banknotes.put(100, (banknotes.get(50) + sumOfMoney));
                break;
            default:
                System.out.println("Банкомат принимает лишь купюры с номиналом 20, 50 или 100!");
                break;
        }
    }
    //Передаем объект банкомата, из которого будем снимать деньги, а также указываем снимаемую сумму
    public static boolean withdrawCash(ATM atm, int sumOfMoney){
        ATM atm1 = atm;
        boolean isWithdrawed = false;
        int banknotes100 = atm1.banknotes.get(100);
        int banknotes50 = atm1.banknotes.get(50);
        int banknotes20 = atm1.banknotes.get(20);
        int sumForWithdraw;
        int sum = sumOfMoney;
        long sumInATM = banknotes100 * 100 + banknotes50 * 50 + banknotes20 * 20;
        int num100 = sum / 100;
        int num50 = sum / 50;
        int num20 = sum / 20;

        if (sum > sumInATM) {
            System.out.println("В банкомате недостаточно денег!");
            return isWithdrawed;

        }
        else {
            for (int i = num100; i >= 0; i--) {
                for (int j = num50; j >= 0; j--) {
                    for (int k = num20; k >= 0; k--) {
                        sumForWithdraw = i * 100 + j * 50 + k * 20;
                        if (sumForWithdraw == sum) {
                            isWithdrawed = true;
                            System.out.println("Операция прошла успешно. Выдано " + i + " купюр по 100 руб., " + j + " купюр по 50 руб. и " + k + " купюр по 20 руб.");
                            return isWithdrawed;
                        } else continue;
                    }
                }

            }
        }
        return isWithdrawed;
    }

}
