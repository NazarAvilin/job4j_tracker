package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Tracker {

    private final List<Item> items = new ArrayList<>();

    private int indexOf(String id) {
        int rsl = -1;
        for (Item item : items) {
            if (item.getId().equals(id)) {
                rsl = items.indexOf(item);
                break;
            }
        }
        return rsl;
    }

    public Item add(Item item) {
        item.setId(generateId());
        this.items.add(item);
        return item;
    }

    private String generateId() {
        Random random = new Random();
        return String.valueOf(((random.nextLong() + System.currentTimeMillis()) / 1000000000) / 100000);
    }

    public List<Item> findAll() {
       return items;
    }

    public List<Item> findByName(String key) {
        List<Item> namesEqualsKey = new ArrayList<>();
        for (Item item : items) {
            if (item.getName().equals(key)) {
                namesEqualsKey.add(item);
            }
        }
        return namesEqualsKey;
    }

    public Item findById(String id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }


    public boolean replace(String id, Item item) {
        int index = indexOf(id);
        boolean rsl = false;
        if (index != -1) {
            item.setId(id);
            items.set(index, item);
            rsl = true;
        }
        return rsl;
    }

    public boolean delete(String id) {
        int index = indexOf(id);
        boolean rsl = false;
        if (index != -1) {
            items.remove(index);
            rsl = true;
        }
        return rsl;
    }

}