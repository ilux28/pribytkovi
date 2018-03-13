package ru.job4j.search;

public class Person {
    private String name;
    private String surname;
    private String phone;
    private String addres;

    public Person(String name, String surname, String phone, String addres) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.addres = addres;
    }
    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public String getPhone() {
        return phone;
    }
    public String getAddres() {
        return addres;
    }
}
