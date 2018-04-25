package ru.job4j.multitreading.nonBlock;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class NonBlockCash {

    private volatile boolean blockCustomer = true;

    public void doSomthing() throws InterruptedException {
        while (this.blockCustomer) {
            System.out.printf("%s userfull work", Thread.currentThread().getId());
        }
    }
    public void changeBlock(boolean enable) {
        System.out.println(String.format("%s enable", Thread.currentThread().getId()));
        this.blockCustomer = enable;
    }
    public static void main(String[] args) {
        new Thread() {
          @Override
          public void run() {

          }
        }.start();
        new Thread() {
            @Override
            public void run() {

            }
        }.start();

      //  List<String> syncList = Collections.synchronizedList(new ArrayList<String>());
      //  CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<String>();


    }
}
