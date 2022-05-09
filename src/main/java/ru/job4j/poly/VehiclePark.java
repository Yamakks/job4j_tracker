package ru.job4j.poly;

public class VehiclePark {
    public static void main(String[] args) {
        Vehicle b1 = new Bus2();
        Vehicle b2 = new Bus2();
        Vehicle b3 = new Bus2();
        Vehicle t1 = new Train();
        Vehicle t2 = new Train();
        Vehicle t3 = new Train();
        Vehicle f1 = new Airplane();
        Vehicle f2 = new Airplane();
        Vehicle f3 = new Airplane();
        Vehicle[] vehicles = new Vehicle[] {b1, t2, b3, t1, f2, t3, f1, b2, f3};
        for (Vehicle v : vehicles) {
            v.move();
            v.fuel();
        }
    }
}
