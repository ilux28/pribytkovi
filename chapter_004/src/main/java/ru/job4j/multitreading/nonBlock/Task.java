package ru.job4j.multitreading.nonBlock;

public class Task {
    private int id;
    private int version;
    private String name;
    public Task(int id, int version, String name) {
        this.id = id;
        this.version = version;
        this.name = name;
    }

    public int getId() {
        return this.id;
    }
    public int getVersion() {
        return this.version;
    }
    public String getName(int id) {
        return this.name;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setVersion() {
        this.version++;
    }
    public void setName(String name) {
        this.name = name;
    }

}
