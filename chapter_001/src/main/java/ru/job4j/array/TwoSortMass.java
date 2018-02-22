package ru.job4j.array;
/**
 * @author ilux28
 * @sience $id$
 * @version 0.1
 */
public class TwoSortMass {
    /**
     * Из двух отсортированых массивов делает третий
     * @param first, second массивы
     * @return возвращает третий.
     */
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