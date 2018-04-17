package ru.job4j.multitreading.poduserconsumer;

public class ProduserCustomer {
    private final Object lock = new Object();
    private boolean blockCustomer = true;
    public void doSomething() throws InterruptedException {
        synchronized (this.lock) {
            if (this.blockCustomer) {
                System.out.println("wait");
                lock.wait();
            }
            System.out.println("userfull work");
        }
    }
    public void changeBlock(boolean enable) {
        synchronized (this.lock) {
            System.out.println("enable");
            this.blockCustomer = enable;
            lock.notify();
        }
    }
    public static void main(String[] args) {
        final ProduserCustomer blockingWork = new ProduserCustomer();
        //customer
        new Thread() {
            @Override
            public void run() {
                try {
                    blockingWork.doSomething();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
        //producer
        new Thread() {
            @Override
            public void run() {
                blockingWork.changeBlock(false);
            }
        }.start();
    }
}
