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
        Calculator calc = new Calculator();
        return sum(a) + minus(a) + calc.multiply(a) +  calc.divide(a);
    }

    public static void main(String[] args) {
        int result = sum(10);
        System.out.println(result);
        Calculator calculator = new Calculator();
        int rsl = calculator.multiply(5);
        System.out.println(rsl);
        double rsl1 =  calculator.divide(8);
        System.out.println(rsl1);
        rsl1 = calculator.sumAllOperation(7);
        System.out.println(rsl1);
    }
}
