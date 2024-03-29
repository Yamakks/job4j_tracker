package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringCompareTest {
    @Test
    public void whenStringsAreEqualThenZero() {
        StringCompare compare = new StringCompare();
        int rst = compare.compare(
                "Ivanov",
                "Ivanov"
        );
        assertThat(rst).isEqualTo(0);
    }

    @Test
    public void whenLeftLessThanRightResultShouldBeNegative() {
        StringCompare compare = new StringCompare();
        int rst = compare.compare(
                "Ivanov",
                "Ivanova"
        );
        assertThat(rst).isLessThan(0);
    }

    @Test
    public void whenLeftGreaterThanRightResultShouldBePositive() {
        StringCompare compare = new StringCompare();
        int rst = compare.compare(
                "Petrov",
                "Ivanova"
        );
        assertThat(rst).isGreaterThan(0);
    }

    @Test
    public void secondCharOfLeftGreaterThanRightShouldBePositive() {
        StringCompare compare = new StringCompare();
        int rst = compare.compare(
                "Petrov",
                "Patrov"
        );
        assertThat(rst).isGreaterThan(0);
    }

    @Test
    public void secondCharOfLeftLessThanRightShouldBeNegative() {
        StringCompare compare = new StringCompare();
        int rst = compare.compare(
                "Patrova",
                "Petrov"
        );
        assertThat(rst).isLessThan(0);
    }

    @Test
    public void lastCharOfLeftGreaterThanRightShouldBePositive() {
        StringCompare compare = new StringCompare();
        int rst = compare.compare(
                "Petroy",
                "Petrov"
        );
        assertThat(rst).isGreaterThan(0);
    }

    @Test
    public void lastCharOfRightGreaterThanLeftShouldBeNegative() {
        StringCompare compare = new StringCompare();
        int rst = compare.compare(
                "Petrov",
                "Petroy"
        );
        assertThat(rst).isLessThan(0);
    }

    @Test
    public void noCharOfLeftShouldBeNegative() {
        StringCompare compare = new StringCompare();
        int rst = compare.compare(
                "",
                "Petroy"
        );
        assertThat(rst).isLessThan(0);
    }

    @Test
    public void noCharOfRightShouldBePositive() {
        StringCompare compare = new StringCompare();
        int rst = compare.compare(
                "Abcd",
                ""
        );
        assertThat(rst).isGreaterThan(0);
    }

    @Test
    public void leftCharUppercaseShouldBeNegative() {
        StringCompare compare = new StringCompare();
        int rst = compare.compare(
                "ABCD",
                "abcd"
        );
        assertThat(rst).isLessThan(0);
    }

    @Test
    public void mixedRegisterBeNegative() {
        StringCompare compare = new StringCompare();
        int rst = compare.compare(
                "aBcD",
                "abCD"
        );
        assertThat(rst).isLessThan(0);
    }

}