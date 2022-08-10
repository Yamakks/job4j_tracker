package ru.job4j.tracker;

import java.util.ArrayList;

public class StartUI {
    private final Output out;

    public StartUI(Output out) {
        this.out = out;
    }

    public void init(Input input, Tracker tracker, ArrayList<UserAction> actions) {
        boolean run = true;
        while (run) {
            showMenu(actions);
            int select = input.askInt("Select: ");
            if (select < 0 || select >= actions.size()) {
                out.println("Wrong input, you can select: 0 .. " + (actions.size() - 1));
                continue;
            }
            UserAction action = actions.get(select);
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(ArrayList<UserAction> actions) {
        out.println("Menu:");
        for (UserAction action : actions) {
            out.println(actions.indexOf(action) + ". " + action.name());
        }
    }

    public static void main(String[] args) {
        Output out = new ConsoleOutput();
        Input input = new ValidateInput(out, new ConsoleInput());
        Tracker tracker = new Tracker();
        ArrayList<UserAction> actions = new ArrayList<>();
                actions.add(new CreateAction(out));
                actions.add(new DeleteAction(out));
                actions.add(new EditAction(out));
                actions.add(new FindAllAction(out));
                actions.add(new FindByNameAction(out));
                actions.add(new FindItemByIdAction(out));
                actions.add(new ExitAction());
        new StartUI(out).init(input, tracker, actions);
    }
}
