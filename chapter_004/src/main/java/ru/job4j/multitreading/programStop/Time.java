package ru.job4j.multitreading.programStop;

public class Time {
    public static final class TimeCount implements Runnable {
        long time;
        public TimeCount(long time) {
            this.time = time;
        }
        @Override
        public void run() {
            if (System.currentTimeMillis() - time > 5000) {
                Thread.currentThread().interrupt();
            }
            System.out.println(System.currentTimeMillis() - time);
        }
    }
    public static  void main(String[] args) {
        String x = "Кошка бросила котят, пусь лазают как хотят";
        long startTime = System.currentTimeMillis();
        Thread z = new Thread(new CharCount(x));
        Thread y = new Thread(new TimeCount(startTime));
        z.start();
        y.start();
        if (y.isAlive()) {
            try {
                y.join();
                z.join();
            } catch (InterruptedException e) { }
            if (z.isAlive())
                z.interrupt();
        }
        System.out.print("Finish!");
    }
}
