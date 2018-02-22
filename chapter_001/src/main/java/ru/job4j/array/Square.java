package ru.job4j.array;
/**
 * @author ilux28
 * @sience $id$
 * @version 0.1
 */
public class Square {
    /**
     * заполняет массив квдратами натуральных чисел
     * @param bound размер
     * @return возвращает этот массив.
     */
    public int[] calculate(int bound) {
        int[] rsl = new int[bound];
        for (int i = 0; i < bound; i++)
            rsl[i] = (i + 1) * (i + 1);
        return rsl;
    }
}
