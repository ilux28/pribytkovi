package ru.job4j.multitreading.storage;

public class User {
    private int id;
    private int amount;
    public User(int id, int amount) {
        this.id = id;
        this.amount = amount;
    }
    public int getId() {
        return this.id;
    }
    public int getAmount() {
        return this.amount;
    }
    public void setId() {
        this.id = id;
    }
    public void setAmount() {
        this.amount = amount;
    }
}
