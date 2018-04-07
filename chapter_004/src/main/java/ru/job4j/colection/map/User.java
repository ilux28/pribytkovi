package ru.job4j.colection.map;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class User {
    String name;
    int children;
    Calendar birthday;
    public User(String name, int cildren, Calendar birthday) {
        this.name = name;
        this.children = cildren;
        this.birthday = birthday;
    }
    public static void main(String[] args) {
        User user1 = new User("casha", 12, new GregorianCalendar(1986, 28, 11));
        User user2 = new User("casha", 12, new GregorianCalendar(1986, 28, 11));
        Map<User, Object> map = new HashMap<User, Object>();
        map.put(user1, 0);
        map.put(user2, 0);
        System.out.println(map);
    }
}
