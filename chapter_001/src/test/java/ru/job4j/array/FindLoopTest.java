package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FindLoopTest {
    @Test
    public void whoIndex() {
        FindLoop re = new FindLoop();
        int[] rl = { 1, 5, 7, 6};
        int result = re.indexOf( rl, 6);
        int expended = 3;
        assertThat(result, is(expended));
    }

    @Test
    public void wwhoIndex() {
        FindLoop re = new FindLoop();
        int[] rl = { 1, 5, 7, 6};
        int result = re.indexOf( rl, 3);
        int expended = -1;
        assertThat(result, is(expended));
    }
}
