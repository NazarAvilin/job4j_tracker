package ru.job4j.lambda;

import org.junit.Test;
import static org.hamcrest.core.Is.is;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import static org.hamcrest.MatcherAssert.assertThat;


public class SchoolTest {
    private final List<Student> students = Arrays.asList(new Student(50),
            new Student(30), new Student(45), new Student(100),
            new Student(65), new Student(80));

    @Test
    public void whenScoreFromZeroToFifty() {
        List<Student> result = School.collect(students,
                st -> st.getScore() < 50 && st.getScore() >= 0);
        assertThat(result, is(Arrays.asList(new Student(30), new Student(45))));
    }

    @Test
    public void whenScoreFromFiftyToSeventy() {
        List<Student> result = School.collect(students,
                st -> st.getScore() < 70 && st.getScore() >= 50);
        assertThat(result, is(Arrays.asList(new Student(50), new Student(65))));
    }

    @Test
    public void whenScoreFromSeventyToOneHundred() {
        List<Student> result = School.collect(students,
                st -> st.getScore() <= 100 && st.getScore() >= 70);
        assertThat(result, is(Arrays.asList(new Student(100), new Student(80))));
    }
}