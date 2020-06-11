package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        int countre = Math.min(left.length(), right.length());
        int rsl = 0;
        for (int i = 0; i < countre; i++) {
            rsl = Character.compare(left.charAt(i), right.charAt(i));
            if (rsl != 0) {
                break;
            }
        }
        if (rsl == 0) {
            rsl = left.length() - right.length();
        }
        return rsl;
    }

}
