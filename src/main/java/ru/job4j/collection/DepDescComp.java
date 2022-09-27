package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String[] s1 = o1.split("/");
        String[] s2 = o2.split("/");
        int rsl = s2[0].compareTo(s1[0]);
        if (rsl == 0 && s1.length == s2.length) {
            for (int i = 1; i < s1.length; i++) {
                rsl = s1[i].compareTo(s2[i]);
            }
        } else if (rsl == 0) {
            rsl = o1.compareTo(o2);
        }
        return rsl;
    }
}
