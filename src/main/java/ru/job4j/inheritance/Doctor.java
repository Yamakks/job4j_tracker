package ru.job4j.inheritance;

public class Doctor extends Profession {

    private int practice;

    public Doctor(String name, String surname, String education, String birthday, int practice) {
        super(name, surname, education, birthday);
        this.practice = practice;
    }

    public int getPractice() {
        return practice;
    }
}
