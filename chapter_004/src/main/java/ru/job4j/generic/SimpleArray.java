package ru.job4j.generic;

public class SimpleArray <T>{
    private Object[] objects;
    int i = 0;

    public SimpleArray(int size) {
        this.objects = new Object[size];
    }

    public void add(T model) {
        this.objects[i++] = model;
    }
    public void set(int i, T model) {
        this.objects[i] = model;
    }
    public void delete(int i) {
        System.arraycopy(objects, i + 1, objects, i, objects.length - i - 1);
        objects[objects.length - 1] = 0;
    }
    public T get(int i) {
        return (T) this.objects[i];
    }

}
