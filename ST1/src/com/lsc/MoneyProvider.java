package com.lsc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class MoneyProvider {
    private List<Integer> values = new ArrayList<>();
    private List<Integer> amounts = new ArrayList<>();
    private int totalMoney = 0;

    public MoneyProvider() {
        values.addAll(Arrays.asList(50, 20, 10, 5, 1));
        amounts.addAll(Arrays.asList(1, 1, 1, 2, 3));
    }

    public MoneyProvider(Collection<Integer> mValues, Collection<Integer> mAmounts) {
        values.addAll(mValues);
        amounts.addAll(mAmounts);
    }

    public boolean afford(int money) {
        if (money > getTotalMoney() || money < 0) {
            return false;
        } else {
            return spend(0, money);
        }
    }

    private boolean spend(int index, int num) {
        if (num == 0) {
            return true;
        } else if (index >= values.size() || index >= amounts.size()) {
            return false;
        } else{
//            System.out.println("start:    "+num);
            int i = index;
            for (; i < values.size() && i < amounts.size(); ++i) {

                if (values.get(i) <= num) {
                    if (amounts.get(i) > 0) {
                        amounts.set(i, amounts.get(i) - 1);
                        num -= values.get(i);

                        break;
                    }
                }

            }
//            System.out.println("end:    "+num);
//            System.out.println("endIndex:    "+i);

            return spend(i, num);
        }
    }

    private int getTotalMoney() {
        if (totalMoney == 0) {
            for (int i = 0; i < values.size() && i < amounts.size(); ++i) {
                totalMoney += values.get(i) * amounts.get(i);
            }
        }

        return totalMoney;
    }


}
