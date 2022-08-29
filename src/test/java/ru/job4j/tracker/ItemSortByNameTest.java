package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ItemSortByNameTest {
    @Test
    public void whenAscSort() {
        List<Item> items = Arrays.asList(
                new Item(0, "Yakovlev"),
                new Item(1, "Bobrov"),
                new Item(2, "Aakovlev"),
                new Item(3, "Abuzov")
        );
        List<Item> expected = Arrays.asList(
                new Item(2, "Aakovlev"),
                new Item(3, "Abuzov"),
                new Item(1, "Bobrov"),
                new Item(0, "Yakovlev")
        );
        items.sort(new ItemAscByName());
        assertEquals(expected, items);
    }

    @Test
    public void whenDescSort() {
        List<Item> items = Arrays.asList(
                new Item(0, "Yakovlev"),
                new Item(1, "Bobrov"),
                new Item(2, "Aakovlev"),
                new Item(3, "Abuzov")
        );
        List<Item> expected = Arrays.asList(
                new Item(0, "Yakovlev"),
                new Item(1, "Bobrov"),
                new Item(3, "Abuzov"),
                new Item(2, "Aakovlev")

        );
        items.sort(new ItemDescByName());
        assertEquals(expected, items);
    }
}