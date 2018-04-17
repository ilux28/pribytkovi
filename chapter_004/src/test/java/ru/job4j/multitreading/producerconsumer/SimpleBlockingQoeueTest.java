package ru.job4j.multitreading.producerconsumer;

import org.junit.Test;
import sun.java2d.pipe.SpanShapeRenderer;

import static org.junit.Assert.*;

public class SimpleBlockingQoeueTest {
    SimpleBlockingQueue queue = new SimpleBlockingQueue(5);
    Thread producer = new Thread(new Runnable() {
        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                try {
                    queue.offer(i);
                    System.out.println("Передаем " + i);
                } catch (InterruptedException e) {

                }

            }
            producer.interrupted();
        }
    });
    Thread concumer = new Thread(new Runnable() {
        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                try {
                    System.out.println("Получаем " + queue.poll());
                } catch (InterruptedException e) {

                }
            }
            concumer.interrupted();
        }
    });
    public static void main(String args[]) throws InterruptedException {
        SimpleBlockingQoeueTest test = new SimpleBlockingQoeueTest();
        test.producer.start();
        test.concumer.start();
        test.producer.join();
        test.concumer.join();

        System.out.println("Потоки остановлены!");

    }
    //@Test
}