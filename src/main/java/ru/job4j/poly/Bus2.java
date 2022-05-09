package ru.job4j.poly;

public class Bus2 implements Vehicle {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " Move on road");
    }

    @Override
    public void fuel() {
        System.out.println(getClass().getSimpleName() + " Move on gasoline");

    }
}
