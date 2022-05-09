package ru.job4j.inheritance;

public class PizzaExtraCheeseExtraTomato extends PizzaExtraCheese {
    private static final String EXSTRA_TOMATO = "Exstra Tomato";

    @Override
    public String name() {
        return super.name() + " + " + EXSTRA_TOMATO;
    }
}
