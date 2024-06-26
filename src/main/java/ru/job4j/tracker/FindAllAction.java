package ru.job4j.tracker;

import java.util.List;

public class FindAllAction implements UserAction {
    private final Output out;

    public  FindAllAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Show All Items";
    }

    @Override
    public boolean execute(Input input, Store memTracker) {
        List<Item> items = memTracker.findAll();
        if (items.size() > 0) {
            for (Item item : items) {
                out.println(item);
            }
        } else {
                out.println("Хранилище еще не содержит заявок");
        }
        return true;
    }
}
