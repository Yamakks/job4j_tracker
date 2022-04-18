package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book crime = new Book("Преступление и наказание", 300);
        Book war = new Book("Война и мир", 1500);
        Book poems = new Book("Сборник стихов", 100);
        Book clean = new Book("Clean code", 400);
        Book[] books = new Book[4];
        books[0] = crime;
        books[1] = war;
        books[2] = poems;
        books[3] = clean;
        Book b;
        System.out.println("Книги в изначальной последовательности");
        for (int i = 0; i < books.length; i++) {
            b = books[i];
            System.out.println((i + 1) + ". " + b.getTittle() + " - " + b.getNumber());
        }
        b = books[3];
        books[3] = books[0];
        books[0] = b;
        System.out.println("Книги №1 и №4 поменяны местами");
        for (int i = 0; i < books.length; i++) {
            b = books[i];
            System.out.println((i + 1) + ". " + b.getTittle() + " - " + b.getNumber());
        }
        System.out.println("Книга \"Clean code\"");
        for (int i = 0; i < books.length; i++) {
            b = books[i];
            if ("Clean code".equals(b.getTittle())) {
                System.out.println(b.getTittle() + " - " + b.getNumber());
                break;
            }
    }
}
}
