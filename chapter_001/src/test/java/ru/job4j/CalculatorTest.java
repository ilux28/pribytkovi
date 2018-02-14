package ru.job4j;

import org.junit.Test;
import ru.job4j.calculator.Calculator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class CalculatorTest {
    @Test
    public void whenAddOnePlusOneThenTwo() {
        Calculator calc = new Calculator();
        calc.add(1D, 1D);
        double result = calc.getResult();
        double expected = 2D;
        assertThat(result, is(expected));
    }

    @Test
    public void substractTest() {
        Calculator calc = new Calculator();
        calc.substract(34, 15);
        double result = calc.getResult();
        double expected = 19;
        assertThat(result, is(expected));
    }

    @Test
    public void multipleTest() {
        Calculator calc = new Calculator();
        calc.multiple(12, 3);
        double result = calc.getResult();
        double expected = 36;
        assertThat(result, is(expected));
    }

    @Test
    public void divTest() {
        Calculator calc = new Calculator();
        calc.div(36, 3);
        double result = calc.getResult();
        double expected = 12;
        assertThat(result, is(expected));
    }
}
