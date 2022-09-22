package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class DepartmentsTest {

    @Test
    public void whenMissed() {
        List<String> input = Arrays.asList("k1/sk1/ssk1/ssk2", "k2/sk1");
        List<String> expect = Arrays.asList("k1", "k1/sk1", "k1/sk1/ssk1", "k1/sk1/ssk1/ssk2", "k2", "k2/sk1");
        List<String> result = Departments.fillGaps(input);
        assertThat(result).containsAll(expect);
    }

}