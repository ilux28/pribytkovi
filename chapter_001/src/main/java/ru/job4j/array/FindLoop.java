package ru.job4j.array;
/**
 * @author ilux28
 * @sience $id$
 * @version 0.1
 */
public class FindLoop {
    /**
     * Ищет в массиве заданный элемент
     * @param data массив
     * @return rsl индекс найденного  элемента.
     */
    public int indexOf(int[] data, int el) {
        int rsl = -1;
        for (int i =0; i < data.length; i++) {
            if (data[i] == el) {
                rsl = i;
                break;
            }
        }
            return rsl;
    }
}

