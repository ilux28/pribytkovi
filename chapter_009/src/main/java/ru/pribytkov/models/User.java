package ru.pribytkov.models;

import com.sun.jmx.snmp.Timestamp;

public class User {
    private int id;
    private String name;
    private String email;
    private String password;
    private Timestamp createDate;



    private static User user = new User();
    public static User getUser() {
        return user;
    }
    User() {
    }
    User(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
    public User(int id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }
    public int getId() {
        return this.id;
    }
    public String getEmail() {
        return this.email;
    }
    public String getName() {
        return this.name;
    }
    public Timestamp getCreateDate() {
        return this.createDate;
    }
    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
