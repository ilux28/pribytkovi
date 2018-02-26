package ru.job4j.incapsulate;

import java.util.*;

public class Tracker {

    private Item[] items = new Item[10];
    private int position = 0;
    private static final Random RN = new Random();

    public Item add(Item item) {
        item.setId(generateId());
        this.items[position++] = item;
        return item;
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
    public Item[] getAll() {
        Item[] result = new Item[this.position];
        for (int index = 0; index != this.position; index++) {
            result[index] = this.items[index];
        }return result;
    }
    public void replace(String id, Item item) {
        for (int i = 0; i < this.position; i++) {
            if (this.items[i] != null && this.items[i].getId().equals(id)) {
                item.setId(id);
                items[i] = item;
                break;
            }
        }
    }
    public void delete(String id) {
        for (int i = 0; i < this.position; i++) {
            if (this.items[i] != null && this.items[i].getId().equals(id)) {
                System.arraycopy( this.items, i + 1, this.items, i, this.position - i);
                this.position--;
                break;
            }
        }
    }
    public Item[] findAll() {
        Item[] result = new Item[this.position - 1];;
        for (int i = 0; i < this.position; i++) {
            if (this.items[i] == null) {
                System.arraycopy(this.items, 0, result, 0, i - 1);
                break;
            }
        }
        return result;
    }
    public Item[] findByName(String key) {
        Item[] res = new Item[this.position];
        int j = 0;
        for (int i = 0; i < this.position; i++) {
            if (this.items[i].getName() == key) {
            System.arraycopy(this.items, i, res, j, 1);
            j++;
            }
        } return res;
    }
}
