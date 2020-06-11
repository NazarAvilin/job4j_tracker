package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        int first, second;
        first = Integer.valueOf(left.split(". ")[0]);
        second = Integer.valueOf(right.split(". ")[0]);
        return Integer.compare(first, second);
    }

}

