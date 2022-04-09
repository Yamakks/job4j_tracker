package ru.job4j.oop;

public class Calculator {

    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public static int minus(int y) {
        return y - x;
    }

    public double divide(int n) {
        return (double) n / x;
    }

    public int multiply(int a) {
        return x * a;
    }

    public double sumAllOperation(int a) {
        return sum(a) + minus(a) + this.multiply(a) + this.divide(a);
    }

    public static void main(String[] args) {
        System.out.println("Operation 'sum' is " + sum(7));
        System.out.println("Operation 'minus' is " + minus(7));
        Calculator calculator = new Calculator();
        System.out.println("Operation 'multiply' is " + calculator.multiply(7));
        System.out.println("Operation 'divide' is " + calculator.divide(7));
        System.out.println("Operation 'sumAllOperation' is " + calculator.sumAllOperation(7));
    }
}
