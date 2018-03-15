package ru.job4j.incapsulate;

import java.util.*;

public class Tracker {

    private List<Item> items = new ArrayList<Item>();
    private int position = 0;
    private static final Random RN = new Random();

    public Item add(Item item) {
        item.setId(generateId());
        items.add(items.size(), item) ;
        return item;
    }
    public void edit(Item fresh){
        for (Item item : items) {
            if (item != null && item.getId().equals(fresh.getId())) {
                System.out.println("log 1");
                item = fresh;
                break;
            }
        }
    }
    protected Item findById(String id) {
        Item result = null;
        for (Item item : items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
                break;
            }
        }return result;
    }
    String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }

    public ArrayList<Item> getAll() {
        ArrayList<Item> result = new ArrayList<Item>();
        for (Item item : items) {
            result.add(item);
        }return result;
    }
    public void replace(String id, Item item) {
        for (Item it : items) {
            if (it != null && it.getId().equals(id)) {
                item.setId(id);
                break;
            }
        }
    }
    public void delete(String id) {
        for (Item item : items) {
            if (item != null && item.getId().equals(id)) {
                items.remove(item);
                break;
            }
        }
    }
    public List<Item> findAll() {
        return items;
    }
    public ArrayList<Item> findByName(String key) {
        ArrayList<Item> it = new ArrayList<Item>();
        for (Item item : items) {
            if (item.getName().equals(key)) {
            it.add(item);
            }
        } return it;
    }
}

