package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BubleSortTest {
    @Test
    public void puzirTest() {
        BubleSort ty = new BubleSort();
        int[] array = {5, 3, 2, 1, 7, 6, 8, 9, 4};
        int[] result = ty.sort(array);
        int[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        assertThat(result, is(expected));
    }

}
