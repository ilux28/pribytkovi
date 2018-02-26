package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TwoSortMassTest {
    @Test
    public void whenStartWithPrefixThenTrue() {
        int[] a = {0, 2, 4};
        int[] b = {1, 3, 5};
        MassSortTwo re = new MassSortTwo();
        int[] result = re.rezVozr(a, b);
        int[] expended = {0, 1, 2, 3, 4, 5};
        assertThat(result, is(expended));
    }
}



