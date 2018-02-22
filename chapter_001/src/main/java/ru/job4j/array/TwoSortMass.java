package ru.job4j.array;

/**
 * @author ilux28
 */
public class TwoSortMass {
    public int[] rezVozr(int[] first, int[] second) {
        int[] result = new int[first.length + second.length];
        int j = 0, k = 0;
        for (int i = 0; i < result.length; i++) {

            if (first[j] < second[k]) {
                result[i] = first[j];
                if (j < first.length) j++;
            } else {
                result[i] = second[k];
                if (k < second.length) k++;
            }
        } return result;


    }
}