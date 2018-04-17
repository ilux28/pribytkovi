package ru.job4j.multitreading.problemtread;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class CounterTest {
    private class ThreadCount extends Thread {
        private final Counter counter;
        private ThreadCount(final Counter counter) {
            this.counter = counter;
        }
        @Override
        public void run() {
            this.counter.increaseCounter();
        }
    }
    @Test
    public void whenExecute2ThreadThen2() throws InterruptedException {
        final Counter counter = new Counter();
        Thread first = new ThreadCount(counter);
        Thread second = new ThreadCount(counter);
        first.start();
        second.start();
        first.join();
        first.join();
        assertThat(counter.getCounter(), is(2));
    }
}