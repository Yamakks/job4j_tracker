package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("example@yandex.ru", "Ivanov Ivan Ivanovich");
        map.put("example2@yandex.ru", "Ivanov Ivan Ivanovich");
        map.put("example3@yandex.ru", "Ivanov Ivan Ivanovich");
        map.put("example@yandex.ru", "Ivanchuk Ivan Ivanovich");
        for (String key : map.keySet()) {
            String value = map.get(key);
            System.out.println(key + " = " + value);
        }
    }
}
