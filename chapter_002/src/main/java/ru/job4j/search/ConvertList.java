package ru.job4j.search;

import java.util.ArrayList;
import java.util.List;

public class ConvertList {
    List<Integer> mass = new ArrayList<>();
    public List<Integer> toList(int[][] array) {
        for (int[] arr : array) {
            for (int a : arr) {
                mass.add(0, a);
            }
        } return mass;
    }
    public int[][] toArray(List<Integer> list, int rows) {
        int[][] ar = new int[rows][list.size() / rows];
        Integer a;
        for (int j = 0; j < rows; j++) {
            for (int i = 0; i < list.size() / rows; i++) {
                if (list.size() > 0) {
                    ar[j][i] = list.remove(list.size());
                } else {
                    ar[j][i] = 0;
                }
            }

        } return ar;

    }
}
