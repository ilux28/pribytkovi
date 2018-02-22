package ru.job4j.array;
/**
 * @author ilux28
 * @sience $id$
 * @version 0.1
 */
public class Turn {
    public int[] back(int[] array) {
        /**
        * разворачивает данный массив
        * @param array массив
        * @return возвращает егоже.
        */
        for (int i = 0; i < Math.floor(array.length / 2); i++) {
             int e = array[i];
             array[i] = array[array.length - 1 - i];
             array[array.length - 1 - i] = e;
            }
        return array;
    }
}
