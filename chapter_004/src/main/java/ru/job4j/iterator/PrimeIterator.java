package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class PrimeIterator implements Iterator {
    private int[] arr;
    private int i = 0;

    public PrimeIterator(int[] arr) {
        this.arr = arr;
    }
    public boolean simpleNum(int a) {
        boolean bit = false;
        if (a == 2) {
            bit = true;
        } else if(a > 2) {
            for (int n = 2; n < a; n++) {
                if (a % n == 0) {
                    bit = false;
                    break;
                } else bit = true;
            } return bit;
        } return bit;
    }
    @Override
    public boolean hasNext() {
        int l = arr.length;
        boolean bool = false;
        for (int n = i; n < l; n++) {
            if (simpleNum(arr[n])) {
                bool = true;
                break;
            }
        }
        return bool;
    }
    @Override
    public Object next() throws NoSuchElementException {
        Object x = new Object();
        int l = arr.length;
        if (!hasNext()) {
            throw new NoSuchElementException();
        } else {
            for (int j = i; j < l; j++) {
                if (simpleNum(arr[j])) {
                    x = arr[j];
                    i = ++j;
                    break;
                }
            }return x;
        }
    }
}


