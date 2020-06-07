package ru.job4j.collection;

import javax.lang.model.util.Elements;
import java.util.HashSet;

public class UniqueText {

    public static boolean isEquals(String originText, String duplicateText) {
        boolean rsl = true;
        String[] origin = originText.split(" ");
        String[] text = duplicateText.split(" ");
        HashSet<String> check = new HashSet<>();
        for (String org : origin) {
            check.add(org);
        }
        for (String dub : text) {
            if (!check.contains(dub)) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }

}
