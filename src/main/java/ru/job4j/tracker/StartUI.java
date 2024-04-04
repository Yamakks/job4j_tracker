package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class StartUI {
    private final Output out;

    public StartUI(Output out) {
        this.out = out;
    }

    public void init(Input input, Store memTracker, List<UserAction> actions) {
        boolean run = true;
        while (run) {
            showMenu(actions);
            int select = input.askInt("Select: ");
            if (select < 0 || select >= actions.size()) {
                out.println("Wrong input, you can select: 0 .. " + (actions.size() - 1));
                continue;
            }
            UserAction action = actions.get(select);
            run = action.execute(input, memTracker);
        }
    }

    private void showMenu(List<UserAction> actions) {
        out.println("Menu:");
        for (int i = 0; i < actions.size(); i++) {
            out.println(i + ". " + actions.get(i).name());
        }
    }

    public static void main(String[] args) {
        Output out = new ConsoleOutput();
        Input input = new ValidateInput(out, new ConsoleInput());
       /* MemTracker memTracker = new MemTracker();
        List<UserAction> actions = new ArrayList<>();
                actions.add(new CreateAction(out));
                actions.add(new DeleteAction(out));
                actions.add(new EditAction(out));
                actions.add(new FindAllAction(out));
                actions.add(new FindByNameAction(out));
                actions.add(new FindItemByIdAction(out));
                actions.add(new ExitAction());
        new StartUI(out).init(input, memTracker, actions);*/
        try (Store tracker = new SqlTracker()) {
            List<UserAction> actions = List.of(
                    new CreateAction(out),
                    new EditAction(out),
                    new DeleteAction(out),
                    new FindAllAction(out),
                    new FindItemByIdAction(out),
                    new FindByNameAction(out),
                    new ExitAction()
            );
            new StartUI(out).init(input, tracker, actions);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
