package ru.job4j.tracker;

import java.util.ArrayList;

public class StubInput implements Input {

    private ArrayList<String> answers = new ArrayList<>();

    private int position = 0;

    public StubInput(ArrayList<String> answers) {
        this.answers.addAll(answers);
    }

    @Override
    public String askStr(String question) {
        return answers.get(position++);
    }

    @Override
    public int askInt(String question) {
        return Integer.parseInt(askStr(question));
    }
}
