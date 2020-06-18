package ru.job4j.lambda;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import static org.hamcrest.MatcherAssert.assertThat;


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
    public void whenMapTest() {
        Map<String, Student> result = students.stream().collect(Collectors.toMap(Student::getSurname, st -> st));
        assertThat(result, is(List.of(new Student("Max", 45))));
    }

}