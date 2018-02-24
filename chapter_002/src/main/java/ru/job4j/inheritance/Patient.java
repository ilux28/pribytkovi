package ru.job4j.inheritance;
/**
 * @author ilux28
 * @sience $id$
 * @version 0.1
 */
public class Patient {
    String name;
    public Patient(String name) {
        this.name = name;
    }
    /**
     * Пациент имеет только name умеет его возвращать
     * @param
     * @return name
     */
    public String getName() {
        return this.name;
    }
}
