package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    private final Output out;

    public  DeleteAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Delete Item";
    }

    @Override
    public boolean execute(Input input, Store memTracker) {
        out.println("=== Delete item ===");
        int id = input.askInt("Enter id: ");
        int init = memTracker.findById(id).getId();
        if (init != id) {
            out.println("Ошибка удаления заявки. Заявки с данным ID не существует.");
        } else  {
            out.println("Заявка удалена успешно.");
        }
        memTracker.delete(id);

        return true;
    }
}
