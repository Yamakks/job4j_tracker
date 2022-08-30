package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.assertj.core.api.Assertions.assertThat;

class JobTest {

    @Test
    public void whenCompatorByNameReverse() {
        Comparator<Job> cmpNamePriorityReverse = new JobDescByName();
        int rsl = cmpNamePriorityReverse.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenCompatorByName() {
        Comparator<Job> cmpNamePriority = new JobAscByName();
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenCompatorByNameEquals() {
        Comparator<Job> cmpNamePriority = new JobAscByName();
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Impl task", 1)
        );
        assertThat(rsl).isEqualTo(0);
    }

    @Test
    public void whenCompatorByNameAndPrority() {
        Comparator<Job> cmpNamePriorityReverse = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriorityReverse.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

        @Test
        public void whenCompatorByNameAndPrority1() {
            Comparator<Job> cmpNamePriority = new JobAscByName().thenComparing(new JobAscByPriority());
            int rsl = cmpNamePriority.compare(
                    new Job("Impl task", 0),
                    new Job("Fix bug", 1)
            );
            assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenCompatorByPrority() {
        Comparator<Job> cmpNamePriority = new  JobAscByPriority();
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenCompatorByPrority2() {
        Comparator<Job> cmpNamePriority = new  JobDescByPriority();
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenCompatorByPrority3() {
        Comparator<Job> cmpNamePriority = new  JobDescByPriority();
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 0)
        );
        assertThat(rsl).isEqualTo(0);
    }

    @Test
    public void whenCompatorByNameAndPrority2() {
        Comparator<Job> cmpNamePriorityReverse = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriorityReverse.compare(
                new Job("Impl task", 0),
                new Job("Impl task", 1)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenCompatorByNameAndPrority3() {
        Comparator<Job> cmpNamePriorityReverse = new JobDescByName().thenComparing(new JobAscByPriority());
        int rsl = cmpNamePriorityReverse.compare(
                new Job("Impl task", 0),
                new Job("Impl task", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

}