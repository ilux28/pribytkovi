package ru.job4j.sortColection;

import java.util.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

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
        }
        return us;
    }

    public List<User> sortNameLength(List<User> users) {
        Comparator<User> SORT_NAME_LENGTH = new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return String.valueOf(o1.getName().length()).compareTo(String.valueOf(o2.getName().length()));
            }
        };
        return users;
    }

    public List<User> sortByAllFields(List<User> users) {
        Comparator<User> SORT_BY_ALL_FIELD = new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                int x = o1.getName().compareTo(o2.getName());
                int y = o1.getAge() < o2.getAge() ? -1 : 1;
                int z;
                if ( x != 0) {
                    z = x;
                } else {
                    z = y;
                }
                return z;
            }
        };
        return users;
    }
}