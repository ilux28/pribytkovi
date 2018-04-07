package ru.job4j.colection.generic;

public abstract class Store<T extends Base> {
    public abstract void add(T model);
    public abstract boolean replace(String id, T model);
    public abstract boolean delete(String id);
    public abstract T findById(String id);
}
