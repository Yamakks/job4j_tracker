package ru.job4j.oop;

public class Jukebox {
    public void music(int position) {
        String song = "Песня не найдена";
        if (position == 1) {
            song = "Пусть бегут неуклюже";
        } else if (position == 2) {
            song = "Спокойной ночи";
        }
        System.out.println(song);
        }

    public static void main(String[] args) {
        Jukebox box = new Jukebox();
        box.music(0);
        box.music(1);
        box.music(2);
        box.music(3);

    }
}
