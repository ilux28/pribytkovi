package ru.job4j.multitreading.problemtread;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

@ThreadSafe
public class Counter {
    @GuardedBy("this")
    private long counter = 0L;
    public void increaseCounter() {
        counter++;
    }
    public long getCounter() {
        return counter;
    }
}
