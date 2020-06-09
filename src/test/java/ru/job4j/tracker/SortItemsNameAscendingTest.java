package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.List;


public class SortItemsNameAscendingTest {

    @Test
    public void compare() {
        Item stas = new Item("Stas");
        Item petr = new Item("Petr");
        Item andrey = new Item("Andrey");
        Item rail = new Item("Rail");
        List<Item> items = Arrays.asList(stas, petr, andrey, rail);
        items.sort(new SortItemsNameAscending());
        List<Item> sorted = Arrays.asList(andrey, petr, rail, stas);
        assertThat(items, is(sorted));
    }

}