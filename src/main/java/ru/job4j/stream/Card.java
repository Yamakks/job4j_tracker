package ru.job4j.stream;

import java.util.Arrays;
import java.util.stream.Stream;

public class Card {
    private Suit suit;
    private Value value;

    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Card{"
                + "suit=" + suit
                + ",value=" + value
                + '}';
    }

    public static void main(String[] args) {

        Stream.of(Suit.values())
                .flatMap(suits -> Stream.of(Value.values())
                .map(val -> new Card(suits, val)))
                .forEach(System.out::println);
}
}
