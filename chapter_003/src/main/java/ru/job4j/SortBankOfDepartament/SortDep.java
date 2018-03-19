package ru.job4j.SortBankOfDepartament;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class SortDep {
    public String[] sortDepUp(String[] dep) {
        Arrays.sort(dep, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return a.compareTo(b);
            }
        });
        return dep;
    }
    public String[] sortDepDown(String[] dep) {
        Arrays.sort(dep, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return a.compareTo(b) == -1 ? 1 : -1;
            }
        });
        return dep;
    }
    public static void main(String[] args) {
        String[] dep = {"K1/SK1", "K1/SK2","K2/SK1", "K2/SK2", "K1/SK1/SSK1", "K1/SK1/SSK2","K1", "K2", "K2/SK1/SSK1", "K2/SK1/SSK2"};
        SortDep ar = new SortDep();
        String[] depa = ar.sortDepDown(dep);
        for (String x : depa) {
            System.out.println(x);
        }
        /***
        String[] de = ar.sortDepDown(dep);
        for (String x : de) {
            System.out.println(x);
        }
         */
    }
}

