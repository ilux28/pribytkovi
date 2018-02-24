package ru.job4j.array;
/**
 * @author ilux28
 * @sience $id$
 * @version 0.1
 */
public class MassSortTwo {
    /**
     * из двуз массивов делает третий отсортированный
     * @param first second два массива
     * @return возвращает егоже.
     */
    public int[]rezVozr(int[] first, int[] second) {
        int[] result = new int[first.length + second.length];
        int j = 0, k = 0;
        for (int i = 0; i < result.length; i++) {
            if (j > first.length - 1) {
                result[i] = second[k];
                k++;
            }else if (k > second.length - 1) {
                result[i] = first[j];
                j++;
            }else if (first[j] < second[k]) {
                result[i] = first[j];
                j++;
            }else {
                result[i] = second[k];
                k++;
            }
        } return result;
    }
}
