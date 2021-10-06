package dev.dinesh.leetcode.mock;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class InvalidTransactions {
    public List<String> invalidTransactions(String[] transactions) {

        List<String> names = new ArrayList<>();
        List<Integer> times = new ArrayList<>();
        List<Integer> amounts = new ArrayList<>();
        List<String> city = new ArrayList<>();
        List<String> invalidTxns = new ArrayList<>();
        HashSet<Integer> results = new HashSet<>();

        for(int index = 0; index < transactions.length; index++) {
            String[] splitStr = transactions[index].split(",");
            names.add(splitStr[0]);
            times.add(Integer.valueOf(splitStr[1]));
            amounts.add(Integer.valueOf(splitStr[2]));
            city.add(splitStr[3]);
        }

        for(int index = 0; index < transactions.length - 1; index++) {
            for(int subIndex = index+1; subIndex < transactions.length; subIndex++) {

                int diffAmt = Math.abs(times.get(index) - times.get(subIndex));

                if(names.get(index).equals(names.get(subIndex)) && diffAmt <= 60 && !city.get(index).equals(city.get(subIndex))) {
                    results.add(index);
                    results.add(subIndex);
                }

                if(amounts.get(index) > 1000) {
                    results.add(index);
                }

                if(amounts.get(subIndex) > 1000) {
                    results.add(subIndex);
                }

            }
        }

        System.out.println(results);

        for(int index : results) {
            invalidTxns.add(transactions[index]);
        }

        return invalidTxns;

    }
}