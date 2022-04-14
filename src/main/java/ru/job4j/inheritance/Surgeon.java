package ru.job4j.inheritance;

public class Surgeon extends Doctor {

    private String tool;

    public Surgeon(String name, String surname, String education, String birthday, int practice, String tool) {
        super(name, surname, education, birthday, practice);
        this.tool = tool;
    }

    public String getTool() {
        return tool;
    }
}
