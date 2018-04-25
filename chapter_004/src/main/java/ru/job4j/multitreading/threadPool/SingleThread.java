package ru.job4j.multitreading.threadPool;

import sun.nio.ch.ThreadPool;

import static java.lang.String.format;

public class SingleThread {
    public static void main(String[] args) {
        Counter counter = new Counter();
        long start = System.nanoTime();
        double value = 0;
        for (int i = 0; i < 400; i++) {
            value += counter.count(i);
        }
        System.out.println(format("Executed by %d s, value : %f", (System.nanoTime() - start) / (100_000_000), value));

    }
}
