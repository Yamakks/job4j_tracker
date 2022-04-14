package ru.job4j.inheritance;

public class Dentist extends Doctor {

    private String[] drill;

    public Dentist(String name, String surname, String education, String birthday, int practice, String[] drill) {
        super(name, surname, education, birthday, practice);
        this.drill = drill;
    }

    public void showDrill() {
        for (String s : drill) {
            System.out.println(s);
        }
    }
}
