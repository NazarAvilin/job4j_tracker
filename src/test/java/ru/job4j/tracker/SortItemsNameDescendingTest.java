package ru.job4j.tracker;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SortItemsNameDescendingTest {

    @Test
    public void compare() {
        Item stas = new Item("Stas");
        Item petr = new Item("Petr");
        Item andrey = new Item("Andrey");
        Item rail = new Item("Rail");
        List<Item> items = Arrays.asList(stas, petr, andrey, rail);
        items.sort(new SortItemsNameDescending());
        List<Item> sorted = Arrays.asList(stas, rail, petr, andrey);
        assertThat(items, is(sorted));
    }

}