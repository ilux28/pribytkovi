package ru.job4j.array;

public class TwoSortMass {
    public int[] rezVozr(int[] first, int[] second) {
        int[] result = new int[first.length + second.length];
        int[] s;
        int[] t;
        if (first.length > second.length) {
            s = second;
            t = first;
        } else {
            s = first;
            t = second;
        }
        for (int i = 0; i < s.length; i++) {
            if (first[i] > second[i]) {
                result[2 * i] = first[i];
                result[2 * i + 1] = second[i];
            } else {
                result[2 * i] = second[i];
                result[2 * i + 1] = first[i];
            }
        } return result;

         for (int j = 0; j < t.length - s.length; j++)  {
            result[2 * s.length + j] = t[s.length + j];
        } return result;
    }
}