package ru.job4j.tracker;

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
    public boolean execute(Input input, Tracker tracker) {
        Item[] items = tracker.findAll();
        if (items.length > 0) {
            for (Item item : items) {
                out.println(item);
            }
        } else {
                out.println("Хранилище еще не содержит заявок");
        }
        return true;
    }
}
