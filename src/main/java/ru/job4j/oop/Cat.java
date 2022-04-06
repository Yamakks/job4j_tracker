package ru.job4j.oop;

public class Cat {
    public String sound() {
        String voice = "may-may";
        return voice;
    }

    private String food;

    private String name;

    public void show() {
        System.out.println(this.name + " съел " + this.food);
    }

    public void eat(String meat) {
        this.food = meat;
    }

    public void giveNick(String nick) {
        this.name = nick;
    }

    public static void main(String[] args) {
        Cat peppy = new Cat();
        String say = peppy.sound();
        System.out.println("Peppy says " + say);
        System.out.println();
        System.out.println("Котенок гав.");
        Cat gav = new Cat();
        gav.giveNick("Гав");
        gav.eat("kotleta");
        gav.show();
        System.out.println("Котенок блэк.");
        Cat black = new Cat();
        black.giveNick("Черный");
        black.eat("fish");
        black.show();
    }
}
