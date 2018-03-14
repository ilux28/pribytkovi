package ru.job4j.search;

import java.util.ArrayList;
import java.util.List;

public class PhoneDictionary {
    private List<Person> persons = new ArrayList<Person>();
    public void add(Person person) {
        this.persons.add(person);
    }

    public List<Person> find(String key) {
        List<Person> result = new ArrayList<>();
        for(Person item : result) {
            if (item.getName().contains(key) || item.getSurname().contains(key) || item.getPhone().contains(key) || item.getAddres().contains(key)){
                result.add(item);
            }
        }
        return result;
    }
 }
