package ru.job4j.oop;

public class Ball {

    public void tryRun(boolean condition) {
        String rsl = "Колобок съеден";
        if (!condition) {
            rsl = "Колобок убежал";
        }
        System.out.println(rsl);
    }
}
