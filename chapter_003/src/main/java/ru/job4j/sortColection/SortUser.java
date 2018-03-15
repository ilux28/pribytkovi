package ru.job4j.sortColection;

import java.util.*;

public class SortUser {
    public Set<User> sort(List<User> users) {
        Set<User> us = new TreeSet<User>();
        int i = 0;
        while (i < users.size()) {
            if (users.get(i).compareTo(users.get(i + 1)) == -1) {
                us.add(users.get(i));
                i++;
            } else {
                us.add(users.get(i + 1));
                i--;
            }
        } return us;
    }
}
