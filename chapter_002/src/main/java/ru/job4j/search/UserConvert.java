package ru.job4j.search;

import java.util.*;

import java.util.HashMap;

public class UserConvert {
    HashMap<Integer, User> pas = new HashMap<Integer, User>();
    public HashMap<Integer, User> process(List<User> list) {
        for (User user : list) {
            pas.put(user.id, user);
        } return pas;
    }
}
