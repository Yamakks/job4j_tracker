package ru.job4j.oop;

import org.junit.Assert;
import org.junit.Test;

public class TriangleTest {

    @Test
    public void when00and40and04Then8() {
        Point a = new Point(0, 0);
        Point b = new Point(4, 0);
        Point c = new Point(0, 4);
        Triangle triangle = new Triangle(a, b, c);
        double rsl = triangle.area();
        double out = 8;
        Assert.assertEquals(rsl, out, 0.001);
    }

    @Test
    public void when00and00and04ThenMinus1() {
        Point a = new Point(0, 0);
        Point b = new Point(0, 0);
        Point c = new Point(0, 4);
        Triangle triangle = new Triangle(a, b, c);
        double rsl = triangle.area();
        double out = -1;
        Assert.assertEquals(rsl, out, 0.001);
    }
}