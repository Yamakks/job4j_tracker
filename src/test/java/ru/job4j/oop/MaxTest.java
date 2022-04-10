package ru.job4j.oop;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MaxTest {

    @Test
    public void whenMax1to2do2() {
        int left = 1;
        int right = 2;
        int expected = 2;
        int result = Max.max(left, right);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void whenMax3to2do3() {
        int left = 3;
        int right = 2;
        int expected = 3;
        int result = Max.max(left, right);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void whenMax5to5do5() {
        int left = 5;
        int right = 5;
        int expected = 5;
        int result = Max.max(left, right);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void whenMax1to4to2do4() {
        int a = 1;
        int b = 4;
        int c = 2;
        int expected = 4;
        int result = Max.max(a, b, c);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void whenMax2to5to1to7do7() {
        int a = 2;
        int b = 5;
        int c = 1;
        int d = 7;
        int expected = 7;
        int result = Max.max(a, b, c, d);
        Assert.assertEquals(expected, result);
    }
}