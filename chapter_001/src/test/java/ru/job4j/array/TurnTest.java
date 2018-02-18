package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TurnTest {
    @Test
    public void backTestCh() {
        Turn re = new Turn();
        int[] rl = { 1, 5, 7, 6};
        int[] result = re.back(rl);
        int[] expended = {6, 7, 5, 1};
        assertThat(result, is(expended));
    }

    @Test
    public void backTestNch() {
        Turn r = new Turn();
        int[] re = { 1, 5, 7, 6, 10};
        int[] result = r.back(re);
        int[] expended = {10, 6, 7, 5, 1};
        assertThat(result, is(expended));
    }
}
