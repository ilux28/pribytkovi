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
        int j = 0, k = 0, a;

        for (int i = 0; i < result.length; i++) {
            if (j > first.length - 1) {
                result[i] = second[k];
                k++;
            }else if (k > first.length - 1) {
                result[i] = first[j];
                j++;
            }else if (first[j] < second[k]){
                result[i] = first[j];
                j++;
            }else {
                result[i] = second[k];
                k++;
            }
        }return result;
    }
    public static void main(String[] args) {
        int[] a = {0, 2, 4};
        int[] b = {1, 3, 5};
        TwoSortMass re = new TwoSortMass();
        int[] s = re.rezVozr(a, b);
        System.out.println(s);
    }
}