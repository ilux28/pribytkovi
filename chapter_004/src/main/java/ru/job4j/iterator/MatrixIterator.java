package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MatrixIterator implements Iterator {
    private final int[][] value;
    private int i = 0;
    private int j = 0;
    public MatrixIterator(final int[][] value) {
        this.value = value;
    }
   public boolean hasNext() {
       int l = value.length;
        if (i < l - 1) {
            return (value[i].length >= j);
        } else if(l == 0) {
            return false;
        } else return (value[i].length > j);
   }
   public Object next() throws NoSuchElementException {
       if (!hasNext())  { throw new NoSuchElementException(); }
        Object x = new Object();
         try {
            int l = value.length;
            if (i < l && l != 0) {
                if (j < value[i].length) {
                    x = value[i][j++];
                } else {
                    j = 0;
                    x = value[++i][j++];
                }
            }
            return x;
        }
        catch (NoSuchElementException e) {
            return e;
        }
   }
}
