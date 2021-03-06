package ru.job4j.oop;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class PointTest {

    @Test
    public void whenX10Y11X22Y23then2point82() {
        Point p1 = new Point(0, 1);
        Point p2 = new Point(2, 3);
        double expected = 2.82;
        double out = p1.distance(p2);
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void whenx15y11x22y23then3point6() {
        Point p1 = new Point(5, 1);
        Point p2 = new Point(2, 3);
        int x1 = 5;
        int y1 = 1;
        int x2 = 2;
        int y2 = 3;
        double expected = 3.6;
        double out = p1.distance(p2);
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void whenx15y13x24y29then6point08() {
        Point p1 = new Point(5, 3);
        Point p2 = new Point(4, 9);
        double expected = 6.08;
        double out = p1.distance(p2);
        Assert.assertEquals(expected, out, 0.005);
    }

    @Test
    public void whenX1Y1Z1x0y0z0Then1Pouit73() {
        Point p1 = new Point(0, 0, 0);
        Point p2 = new Point(1, 1, 1);
        double expected = 1.73;
        double out = p1.distance3d(p2);
        Assert.assertEquals(expected, out, 0.005);
    }

    @Test
    public void whenX0Y0Z0x0y0z3then3() {
        Point p1 = new Point(0, 0, 0);
        Point p2 = new Point(0, 0, 3);
        double expected = 3;
        double out = p1.distance3d(p2);
        Assert.assertEquals(expected, out, 0.005);
    }
}