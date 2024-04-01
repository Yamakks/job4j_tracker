package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class StartUITest {

   @Test
    public void whenCreateItem() {
        ArrayList<String> questions = new ArrayList<>();
        questions.add("0");
        questions.add("Item name");
        questions.add("1");
        Input in = new StubInput(questions);
        MemTracker memTracker = new MemTracker();
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new CreateAction(new StubOutput()));
        actions.add(new ExitAction());
        new StartUI(new StubOutput()).init(in, memTracker, actions);
        assertEquals("Item name", memTracker.findAll().get(0).getName());
    }

    @Test
    public void whenReplaceItem() {
        MemTracker memTracker = new MemTracker();
        Item item = memTracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        ArrayList<String> questions = new ArrayList<>();
        questions.add("0");
        questions.add(String.valueOf(item.getId()));
        questions.add(replacedName);
        questions.add("1");
        Input in = new StubInput(questions);
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new EditAction(new StubOutput()));
        actions.add(new ExitAction());
        new StartUI(new StubOutput()).init(in, memTracker, actions);
        assertEquals(replacedName, memTracker.findById(item.getId()).getName());
    }

    @Test
    public void whenDeleteItem() {
        MemTracker memTracker = new MemTracker();
        Item item = memTracker.add(new Item("Deleted item"));
        ArrayList<String> questions = new ArrayList<>();
        questions.add("0");
        questions.add(String.valueOf(item.getId()));
        questions.add("1");
        Input in = new StubInput(questions);
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new DeleteAction(new StubOutput()));
        actions.add(new ExitAction());
        new StartUI(new StubOutput()).init(in, memTracker, actions);
        assertNull(memTracker.findById(item.getId()));
    }

    @Test
    public void whenExit() {
        String ln = System.lineSeparator();
        Output out = new StubOutput();
        ArrayList<String> questions = new ArrayList<>();
        questions.add("0");
        Input in = new StubInput(questions);
        MemTracker memTracker = new MemTracker();
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new ExitAction());
        new StartUI(out).init(in, memTracker, actions);
        String expected = "Menu:" + ln
                + "0. Exit" + ln;
        assertEquals(expected, out.toString());
    }

    @Test
    public void whenReplaceItemTestOutputIsSuccessfully() {
        Output out = new StubOutput();
        MemTracker memTracker = new MemTracker();
        Item one = memTracker.add(new Item("test1"));
        String replaceName = "New Test Name";
        ArrayList<String> questions = new ArrayList<>();
        questions.add("0");
        questions.add(String.valueOf(one.getId()));
        questions.add(replaceName);
        questions.add("1");
        Input in = new StubInput(questions);
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new EditAction(out));
        actions.add(new ExitAction());
        new StartUI(out).init(in, memTracker, actions);
        String ln = System.lineSeparator();
        String expected = "Menu:" + ln
                + "0. Edit Item" + ln
                + "1. Exit" + ln
                + "=== Edit item ===" + ln
                + "Заявка изменена успешно." + ln
                + "Menu:" + ln
                + "0. Edit Item" + ln
                + "1. Exit" + ln;
        assertEquals(expected, out.toString());
    }

    @Test
    public void whenFindAllTestOutputIsSuccessfully() {
        Output out = new StubOutput();
        MemTracker memTracker = new MemTracker();
        Item one = memTracker.add(new Item("test1"));
        ArrayList<String> questions = new ArrayList<>();
        questions.add("0");
        questions.add("1");
        Input in = new StubInput(questions);
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new FindAllAction(out));
        actions.add(new ExitAction());
        new StartUI(out).init(in, memTracker, actions);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        String ln = System.lineSeparator();
        String expected = "Menu:" + ln
                + "0. Show All Items" + ln
                + "1. Exit" + ln
                + one + ln
                + "Menu:" + ln
                + "0. Show All Items" + ln
                + "1. Exit" + ln;
        assertEquals(expected, out.toString());
    }

    @Test
    public void whenFindByNameTestOutputIsSuccessfully() {
        Output out = new StubOutput();
        MemTracker memTracker = new MemTracker();
        Item one = memTracker.add(new Item("test1"));
        ArrayList<String> questions = new ArrayList<>();
        questions.add("0");
        questions.add(one.getName());
        questions.add("1");
        Input in = new StubInput(questions);
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new FindByNameAction(out));
        actions.add(new ExitAction());
        new StartUI(out).init(in, memTracker, actions);
        String ln = System.lineSeparator();
        String expected = "Menu:" + ln
                + "0. Find Item by Name" + ln
                + "1. Exit" + ln
                + "=== Find item by name ===" + ln
                + one + ln
                + "Menu:" + ln
                + "0. Find Item by Name" + ln
                + "1. Exit" + ln;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        assertEquals(expected, out.toString());
    }

    @Test
    public void whenFindByIDTestOutputIsSuccessfully() {
        Output out = new StubOutput();
        MemTracker memTracker = new MemTracker();
        Item one = memTracker.add(new Item("test1"));
        ArrayList<String> questions = new ArrayList<>();
        questions.add("0");
        questions.add(String.valueOf(one.getId()));
        questions.add("1");
        Input in = new StubInput(questions);
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new FindItemByIdAction(out));
        actions.add(new ExitAction());
        new StartUI(out).init(in, memTracker, actions);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        String ln = System.lineSeparator();
        String expected = "Menu:" + ln
                + "0. Find Item by ID" + ln
                + "1. Exit" + ln
                + "=== Find item by id ===" + ln
                + one + ln
                + "Menu:" + ln
                + "0. Find Item by ID" + ln
                + "1. Exit" + ln;
        assertEquals(expected, out.toString());
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        ArrayList<String> questions = new ArrayList<>();
        questions.add("2");
        questions.add("0");
        Input in = new StubInput(questions);
        MemTracker memTracker = new MemTracker();
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new ExitAction());
        new StartUI(out).init(in, memTracker, actions);
        String ln = System.lineSeparator();
        String expected = "Menu:" + ln
                + "0. Exit" + ln
                + "Wrong input, you can select: 0 .. 0" + ln
                + "Menu:" + ln
                + "0. Exit" + ln;
        assertEquals(expected, out.toString());
    }
}