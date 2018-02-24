package ru.job4j.inheritance;
/**
 * @author ilux28
 * @sience $id$
 * @version 0.1
 */
public class Profession {
    String name, profession;

    public Profession() {
    }
    public Profession(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
    public String getProfession() {
        return this.profession;
    }
}
