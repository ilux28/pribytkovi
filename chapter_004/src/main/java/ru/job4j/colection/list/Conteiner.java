package ru.job4j.colection.list;

import java.util.ConcurrentModificationException;

public class Conteiner<E> {
    private int intsize = 16;
    private int minsize = 4;
    private Object[] container = new Object[intsize];
    private int counter = 0;
    private int iter = 0;
    private int modCount = counter;

    void add(E value) {
        if (counter == container.length - 1)
            resize(container.length * 2);
        container[counter++] = value;
    }
    E get(int i) {
        return (E) container[i];
    }
    public void remove(int i) {
        for (int j = i; j < counter; j++)
            container[i] = container[i + 1];
        container[counter] = null;
        counter--;
        if (container.length > intsize && counter < container.length)
            resize(container.length / 2);
    }
    public int size() {
        return counter;
    }
    public void resize(int newLength) {
        Object[] newArray = new Object[newLength];
        System.arraycopy(container, 0, newArray, 0, counter);
        container = newArray;
    }
    public boolean hasNext() throws ConcurrentModificationException {
        boolean tr = false;
        if (modCount != counter) {throw new ConcurrentModificationException();}
        if (iter < container.length - 1)
            tr = true;
        return tr;
    }
    public Object next() {
        Object x = new Object();
        if (modCount != counter) {throw new ConcurrentModificationException();}
        if (hasNext())
            x = container[counter++];
        return x;
    }

}
