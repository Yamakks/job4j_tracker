package ru.job4j.inheritance;

public class Customer {
    private String name;
    private int cash;
    private boolean isReady;

    public Customer(String name, int cash, boolean isReady) {
        this.name = name;
        this.cash = cash;
        this.isReady = isReady;
    }

    public boolean getStatus() {
        return isReady;
    }
}
