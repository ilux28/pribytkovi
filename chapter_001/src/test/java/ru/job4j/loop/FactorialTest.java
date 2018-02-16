package ru.job4j.loop;

import org.junit.Test;
import ru.job4j.loop.Factorial;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FactorialTest {
    @Test
    public void whenCalculateFactorialForFiveThenOneHundreedTwenty() {
        Factorial facus = new Factorial();
        int result = facus.calc(5);
        int expected = 120;
        assertThat(result, is(expected));
    }

    @Test
    public void whenCalculateFactorialForZeroThenOne() {
        Factorial facus = new Factorial();
        int result = facus.calc(0);
        int expected = 1;
        assertThat(result, is(expected));
    }
}
