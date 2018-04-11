package ru.job4j.multitreading.problemtread;

public class Counter {
    private long counter = 0L;
    public void increaseCounter() {
        counter++;
    }
    public long getCounter() {
        return counter;
    }
}
