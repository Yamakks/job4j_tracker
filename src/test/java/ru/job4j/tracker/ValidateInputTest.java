package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ValidateInputTest {

    @Test
    public void whenInvalidInput() {
        Output out = new StubOutput();
        ArrayList<String> questions = new ArrayList<>();
        questions.add("one");
        questions.add("1");
        Input in = new StubInput(questions);
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertEquals(1, selected);
    }

    @Test
    public void whenInputMinus() {
        Output out = new StubOutput();
        ArrayList<String> questions = new ArrayList<>();
        questions.add("-1");
        Input in = new StubInput(questions);
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertEquals(-1, selected);
    }

    @Test
    public void whenInputValid() {
        Output out = new StubOutput();
        ArrayList<String> questions = new ArrayList<>();
        questions.add("1");
        Input in = new StubInput(questions);
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertEquals(1, selected);
    }

    @Test
    public void whenInputMoreThatOne() {
        Output out = new StubOutput();
        ArrayList<String> questions = new ArrayList<>();
        questions.add("0");
        questions.add("1");
        questions.add("2");
        Input in = new StubInput(questions);
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertEquals(0, selected);
        selected = input.askInt("Enter menu:");
        assertEquals(1, selected);
        selected = input.askInt("Enter menu:");
        assertEquals(2, selected);
    }
}