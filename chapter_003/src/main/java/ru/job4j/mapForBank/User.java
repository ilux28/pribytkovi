package ru.job4j.mapForBank;

public class User {
    private String name;
    private String pasport;

    public User(String name, String pasport) {
        this.name = name;
        this.pasport = pasport;
    }
    public String getName() {
        return this.name;
    }
    public String getPasport() {
        return this.pasport;
    }
    @Override
    public boolean equals(Object object) {
        boolean x = false;
        if (this == object) {
            x = true;
        } else if (object == null || object.getClass() != this.getClass()) {
            x = false;
        }
        return x;
    }
    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = 1;
        result = PRIME * result + getPasport().length();
        return result;
    }
}
