package ru.job4j.collection;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        ArrayList<String> left = new ArrayList<>(Arrays.asList(o1.split("/")));
        ArrayList<String> right = new ArrayList<>(Arrays.asList(o2.split("/")));
        int counter = Math.min(left.size(), right.size());
        int rsl = 0;
        for (int i = 0; i < counter; i++) {
            int compare = left.get(i).compareTo(right.get(i));
            if (compare != 0) {
                rsl = compare;
                break;
            }
        }
        if (rsl == 0) {
            rsl = left.size() - right.size();
        }
        return rsl;
    }
}
