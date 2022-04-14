package ru.job4j.inheritance;

public class Builder extends Engineer {

    private String workSpace;

    public Builder(String name, String surname, String education, String birthday, int rank, String workSpace) {
        super(name, surname, education, birthday, rank);
        this.workSpace = workSpace;
    }

    public String getWorkSpace() {
        return workSpace;
    }

    public void buildHome() {
    }
}
