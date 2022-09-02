package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String[] left = o1.split(". "), right = o2.split(". ");
        int first = Integer.parseInt(left[0]), second = Integer.parseInt(right[0]);
        return Integer.compare(first, second);
    }
}
