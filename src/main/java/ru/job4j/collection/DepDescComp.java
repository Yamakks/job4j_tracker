package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        int rsl = 0;
        String[] s1 = o1.split("/");
        String[] s2 = o2.split("/");
        rsl = s1[0] == s2[0] ? compare(o1, o2);
        return rsl == 0 ? o1.compareTo(o2) : o2.compareTo(o1);
    }
}
