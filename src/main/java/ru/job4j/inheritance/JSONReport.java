package ru.job4j.inheritance;

public class JSONReport extends TextReport {

    @Override
    public String generate(String name, String body) {
        String sep = System.lineSeparator();
        return "{" + sep + "\t\"name\" : " + "\"" + name + "\"," + sep + "\t\"body\" : " + "\"" + body + "\"" + sep + "}";
    }
}
