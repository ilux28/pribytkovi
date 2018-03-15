package ru.job4j.sortColection;

import java.util.*;

public class User implements Comparable<User> {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
    String getName() {return name; }
    int getAge() {return age;}
    @Override
    public int compareTo(User userNext) {
        return this.age < userNext.getAge() ? -1 : 1;
    }
}
