package ru.job4j.mapForBank;

import java.util.*;

public class Account {
    private int value;
    private int requisites;

    Map<User, List<Account>> map = new HashMap<User, List<Account>>();

    public Account(int value, int requisites) {
        this.value = value;
        this.requisites = requisites;
    }
    String vasia = "василий";
    String pasport = "с паспортом1";
    User vas = new User(vasia, pasport);
    public void addUser(User user) {

    }
    public void deleteUser(User user) {

    }
}
