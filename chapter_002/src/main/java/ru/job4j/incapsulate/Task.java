package ru.job4j.incapsulate;

import ru.job4j.incapsulate.Item;

public class Task extends Item {
    public Task(String name, String deck) {
        this.name = name;
        this.description = deck;
    }
    public String calculatePrice() {
        return "100%";
    }
}
