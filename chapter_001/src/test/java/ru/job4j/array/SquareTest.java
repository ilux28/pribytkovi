package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SquareTest {
    @Test
    public void whoi() {
        Square sq = new Square();
        int[] result = sq.calculate(3);
        System.out.println(result);
        int[] expended = {1, 4, 9};
        assertThat(result, is(expended));
    }
}