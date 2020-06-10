package ru.job4j.collection;

import org.junit.Test;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class JobTest {

    private Job implTask = new Job("Impl task", 0);
    private Job fixBug = new Job("Fix bug", 1);
    private Job fixAnotherBug = new Job("Fix bug", 0);
    private Job writeTest = new Job("Write tests", 2);

    @Test
    public void whenComparatorDescByNameAndPriority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(implTask, fixBug);
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenComparatorAscByNameAndAscPriority() {
        Comparator<Job> cmpName = new JobAscByName().thenComparing(new JobAscByPriority());
        List<Job> unsorted = Arrays.asList(implTask, fixAnotherBug, writeTest, fixBug);
        List<Job> sorted = Arrays.asList(fixAnotherBug, fixBug, implTask, writeTest);
        unsorted.sort(cmpName);
        assertThat(unsorted, is(sorted));
    }

    @Test
    public void whenComparatorDescByNameAndAscPriority() {
        Comparator<Job> cmpName = new JobDescByName().thenComparing(new JobAscByPriority());
        List<Job> unsorted = Arrays.asList(implTask, fixAnotherBug, writeTest, fixBug);
        List<Job> sorted = Arrays.asList(writeTest, implTask, fixAnotherBug, fixBug);
        unsorted.sort(cmpName);
        assertThat(unsorted, is(sorted));
    }

    @Test
    public void whenComparatorAscByName() {
        Comparator<Job> cmpName = new JobAscByName();
        List<Job> unsorted = Arrays.asList(implTask, writeTest, fixBug);
        List<Job> sorted = Arrays.asList(fixBug, implTask, writeTest);
        unsorted.sort(cmpName);
        assertThat(unsorted, is(sorted));
    }

    @Test
    public void whenComparatorDescByName() {
        Comparator<Job> cmpName = new JobDescByName();
        List<Job> unsorted = Arrays.asList(implTask, writeTest, fixBug);
        List<Job> sorted = Arrays.asList(writeTest, implTask, fixBug);
        unsorted.sort(cmpName);
        assertThat(unsorted, is(sorted));
    }

    @Test
    public void whenComparatorAscByPriority() {
        Comparator<Job> cmpName = new JobAscByPriority();
        List<Job> unsorted = Arrays.asList(implTask, writeTest, fixBug, fixAnotherBug);
        List<Job> sorted = Arrays.asList(implTask, fixAnotherBug, fixBug, writeTest);
        unsorted.sort(cmpName);
        assertThat(unsorted, is(sorted));
    }

    @Test
    public void whenComparatorDescByPriority() {
        Comparator<Job> cmpName = new JobDescByPriority();
        List<Job> unsorted = Arrays.asList(implTask, writeTest, fixBug, fixAnotherBug);
        List<Job> sorted = Arrays.asList(writeTest, fixBug, implTask, fixAnotherBug);
        unsorted.sort(cmpName);
        assertThat(unsorted, is(sorted));
    }

}