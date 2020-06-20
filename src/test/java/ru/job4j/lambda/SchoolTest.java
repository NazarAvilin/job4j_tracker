package ru.job4j.lambda;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.hasEntry;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;


public class SchoolTest {
    private final List<Student> students = List.of(new Student("Nazar", 50),
            new Student("Ivan", 30), new Student("Max", 45),
            new Student("Petr", 100), new Student("Vlad", 65),
            new Student("Rail", 80), new Student("Max", 45));

    @Test
    public void whenScoreFromZeroToFifty() {
        List<Student> result = School.collect(students,
                st -> st.getScore() < 50 && st.getScore() >= 0);
        assertThat(result, is(List.of(new Student("Ivan", 30), new Student("Max", 45), new Student("Max", 45))));
    }

    @Test
    public void whenScoreFromFiftyToSeventy() {
        List<Student> result = School.collect(students,
                st -> st.getScore() < 70 && st.getScore() >= 50);
        assertThat(result, is(Arrays.asList(new Student("Nazar", 50), new Student("Vlad", 65))));
    }

    @Test
    public void whenScoreFromSeventyToOneHundred() {
        List<Student> result = School.collect(students,
                st -> st.getScore() <= 100 && st.getScore() >= 70);
        assertThat(result, is(Arrays.asList(new Student("Petr", 100), new Student("Rail", 80))));
    }

    @Test
    public void whenConvertedListToMap() {
        List<Student> students = List.of(
                new Student("Ivan", 50),
                new Student("Vasya", 80),
                new Student("Petr", 90),
                new Student("Juri", 30)
        );
        Map<String, Student> rsl = new School().collectInMap(students);
        for (Map.Entry<String, Student> studentMap : rsl.entrySet()) {
            System.out.println(studentMap.getKey() + " " + studentMap.getValue().toString());
        }
        assertThat(rsl, hasEntry("Petr", new Student("Petr", 90)));
    }



}