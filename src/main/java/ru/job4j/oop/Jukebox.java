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
        Jukebox box1 = new Jukebox();
        for (int i = 0; i < 4; i++) {
            box1.music(i);
        }
    }
}
