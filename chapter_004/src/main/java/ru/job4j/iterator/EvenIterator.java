package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenIterator implements Iterator {
    private int[] arr;
    private int i = 0;

    public EvenIterator(int[] arr) {
        this.arr = arr;
    }
    //Iterator it = new EvenIterator(new int[]{4, 2, 1, 1});

    @Override
    public boolean hasNext() {
        int l = arr.length;
        boolean bool = false;
        if (arr.length > i) {
            for (int j = i; j < l; j++) {
                if (arr[j] % 2 == 0) {
                    bool = true;
                    break;
                } else bool = false;
            } return bool;
        }return bool;
    }
    @Override
    public Object next() throws NoSuchElementException {
        int l = arr.length;
        Object x = new Object();
        if (!hasNext()) {throw new NoSuchElementException();}
        try {
            for (int j = i; j < l; j++) {
                if (arr[j] % 2 == 0
                        ) {
                    x = arr[j];
                    i = j + 1;
                    break;
                }
            } return x;
        }catch (NoSuchElementException e) {
            return e;
        }
    }
}
