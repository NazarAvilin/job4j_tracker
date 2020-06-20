package ru.job4j.collection;

import org.junit.Test;
import java.util.List;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;


public class DepartmentsTest {

    @Test
    public void whenMissed() {
        List<String> input = List.of("k1/sk1/ssk1");
        List<String> expected = List.of("k1", "k1/sk1", "k1/sk1/ssk1");
        List<String> result = Departments.fillGaps(input);
        Departments.sortAsc(result);
        assertThat(result, is(expected));
    }

    @Test
    public void whenNonChange() {
        List<String> input = List.of("k1", "k1/sk1");
        List<String> expected = List.of("k1/sk1", "k1");
        List<String> result = Departments.fillGaps(input);
        assertThat(result, is(expected));
    }

    @Test
    public void whenSecondMissed() {
        List<String> input = List.of("k1", "k1/sk1/ssk1");
        List<String> expected = List.of("k1", "k1/sk1", "k1/sk1/ssk1");
        List<String> result = Departments.fillGaps(input);
        Departments.sortAsc(result);
        assertThat(result, is(expected));
    }

    @Test
    public void compare() {
        int rsl = new DepDescComp().compare(
                "K2/SK1/SSK2",
                "K2/SK1/SSK1"
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenUpDepartmentGoBefore() {
        int rsl = new DepDescComp().compare(
                "K2",
                "K2/SK1"
        );
        assertThat(rsl, lessThan(0));
    }
}