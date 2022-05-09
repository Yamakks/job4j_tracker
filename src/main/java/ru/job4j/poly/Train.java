package ru.job4j.poly;

public class Train implements Vehicle {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " Ride on rails");
    }

    @Override
    public void fuel() {
        System.out.println(getClass().getSimpleName() + " Ride on electrisity");
    }
}
