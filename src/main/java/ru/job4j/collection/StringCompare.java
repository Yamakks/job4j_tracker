package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        int rsl = 0;
        int index = Math.min(o1.length(), o2.length());
        for (int i = 0; i < index; i++) {
            char left = o1.charAt(i);
            char right = o2.charAt(i);
            if (left != right) {
                rsl = Character.compare(left, right);
                break;
            }
        }
        return rsl == 0 ? Integer.compare(o1.length(), o2.length()) : rsl;
    }
}
