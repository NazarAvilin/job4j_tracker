package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Random;

public class Tracker {

    private final Item[] items = new Item[100];
    private int position = 0;

    public Item add(Item item) {
        item.setId(generateId());
        items[position++] = item;
        return item;
    }

    private String generateId() {
        Random random = new Random();
        return String.valueOf(random.nextLong() + System.currentTimeMillis());
    }


    public Item[] findAll() {
        return Arrays.copyOf(items, position);
    }

    public Item[] findByName(String key) {
        Item[] namesEqualsKey = new Item[position];
        int size = 0;
        for (int index = 0; index < position; index++) {
            Item item = items[index];
            if (item.getName().equals(key)) {
                namesEqualsKey[size] = item;
                size++;
            }
        }
        return Arrays.copyOf(namesEqualsKey, size);
    }

    public Item findById(String id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    private int indexOf(String id) {
        int rsl = -1;
        for (int index = 0; index < position; index++) {
            if (items[index].getId().equals(id)) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public boolean replace(String id, Item item) {
        int index = indexOf(id);
        boolean result = false;
        if (index != -1) {
            result = true;
            item.setId(id);
            items[index] = item;
        }
        return result;
    }

    public boolean delete(String id) {
        boolean result = false;
        int index = indexOf(id);
        if (index != -1) {
            result = true;
            System.arraycopy(items, (index + 1), items, index, (position - index));
            items[position - 1] = null;
            position--;
        }
        return result;
    }

}