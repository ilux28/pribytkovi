package ru.job4j.array;

public class Turn {
    public int[] back(int[] array) {

        for (int i = 0; i < Math.floor(array.length / 2); i++) {
             int e = array[i];
             array[i] = array[array.length - 1 - i];
             array[array.length - 1 - i] = e;
            }
        return array;
    }
}
