package ru.job4j.tracker;

import java.util.ArrayList;

public final class SingleTracker {
    private static SingleTracker instance = null;

    private Tracker tracker = new Tracker();

    private SingleTracker() {
    }

    public static SingleTracker getInstance() {
        if (instance == null) {
            instance = new SingleTracker();
        }
        return instance;
    }

    public Item add(Item item) {
        return tracker.add(item);
    }

    public Item findById(int id) {
        return tracker.findById(id);
    }

    public ArrayList<Item> findByName(String name) {
        return tracker.findByName(name);
    }

    public ArrayList<Item> findAll() {
        return tracker.findAll();
    }

    public boolean delete(int id) {
        return tracker.delete(id);
    }

    public boolean replace(int id, Item item) {
        return tracker.replace(id, item);
    }
}
