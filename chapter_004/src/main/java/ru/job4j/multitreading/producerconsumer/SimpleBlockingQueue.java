package ru.job4j.multitreading.producerconsumer;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@ThreadSafe
public class SimpleBlockingQueue<A> {
    @GuardedBy("this")
    private List<A> queue = new LinkedList<>();
    private int limit = 10;

    public SimpleBlockingQueue(int limit) {
        this.limit = limit;
    }
    public synchronized void offer(A item) throws InterruptedException {
        while (this.queue.size() == limit) {
            wait();
        }
        if (this.queue.size() == 0) {
            notifyAll();
        }
        this.queue.add(item);
    }
    public synchronized A poll() throws InterruptedException {
        while (this.queue.size() == 0) {
            wait();
        }
        if (this.queue.size() == this.limit) {
            notifyAll();
        }
        return this.queue.remove(0);
    }
}
