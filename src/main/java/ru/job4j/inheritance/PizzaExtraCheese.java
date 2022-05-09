package ru.job4j.inheritance;

public class PizzaExtraCheese extends Pizza {
    private static final String EXSTRA_CHEESE = "Exstra Cheese";

    @Override
    public String name() {
        return super.name() + " + " + EXSTRA_CHEESE;
    }
}
