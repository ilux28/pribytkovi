package ru.job4j.incapsulate;

public interface UserAction {
    int key();
    void execute(Input input, Tracker tracker);
    String info();
}