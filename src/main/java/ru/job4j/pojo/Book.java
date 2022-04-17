package ru.job4j.pojo;

public class Book {

    private String tittle;
    private int number;

    public Book(String tittle, int number) {
        this.tittle = tittle;
        this.number = number;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
