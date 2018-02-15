package ru.job4j.max;

import org.junit.Test;
import ru.job4j.max.Max;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MaxTest {
    @Test
    public void checkMax() {
        Max maxsim = new Max();
        int result = maxsim.max(1, 3);
        assertThat(result, is(3));
    }

    @Test
    public void checskMax() {
        Max maxim = new Max();
        int result = maxim.max(34, 2);
        assertThat(result, is(34));

    }
}
