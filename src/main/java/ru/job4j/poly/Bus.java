package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void drive() {
        System.out.println("Let's go by Bus");
    }

    @Override
    public void numOfPassenger(int count) {
        System.out.println("В автобусе " + count + " пассажиров.");

    }

    @Override
    public double fuelCost(double fuelToBuy) {
        double price = 46.65;
        return price * fuelToBuy;
    }
}
