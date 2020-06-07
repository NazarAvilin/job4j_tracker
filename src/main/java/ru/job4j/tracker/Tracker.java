package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Tracker {

    private final List<Item> items = new ArrayList<>();
    private int position = 0;

    public Item add(Item item) {
        item.setId(generateId());
        this.items.add(item);
        return item;
    }

    private String generateId() {
        Random random = new Random();
        return String.valueOf(random.nextLong() + System.currentTimeMillis());
    }

    public List<Item> findAll() {
        List<Item> result = new ArrayList<>();
        if (items.size() == 0) {
            System.out.println("Нет заявок!");
        } else {
            result = this.items;
        }
        return result;
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
        Item result = null;
        for (Item item : items) {
            if (item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }

    private int indexOf(String id) {
        int rsl = -1;
        for (int index = 0; index < position; index++) {
            if (items.get(index).getId().equals(id)) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public boolean replace(String id, Item item) {
        boolean result = false;
        for (int i = 0; i < items.size(); i++) {
            if (this.items.get(i).getId().equals(id)) {
                this.items.set(i, item);
                result = true;
                break;
            }
        }
        return result;
    }

    public boolean delete(String id) {
        boolean result = false;
        for (int i = 0; i < items.size(); i++) {
            if (this.items.get(i).getId().equals(id)) {
                items.remove(i);
                result = true;
                break;
            }
        }
        return result;
    }

}