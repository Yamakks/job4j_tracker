package ru.job4j.collection;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        int rsl = 0;
        for (int i = 0; i < o1.length(); i++) {
            left.add((int) o1.charAt(i));
        }
        for (int i = 0; i < o2.length(); i++) {
            right.add((int) o2.charAt(i));
        }
        int index = Math.min(o1.length(), o2.length());
        for (int i = 0; i < index; i++) {
            rsl += Integer.compare(left.get(i), right.get(i));
            }

        rsl = rsl == 0 ? Integer.compare(left.size(), right.size()) : rsl;

        return rsl;
    }
}
