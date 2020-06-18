package ru.job4j.lambda;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class School {
    public static List<Student> collect(final List<Student> students, final Predicate<Student> predict) {
        return students.stream().filter(predict).collect(Collectors.toList());
    }

    public Map<String, Student> collectInMap(List<Student> students) {
        return students.stream().collect(Collectors.toMap(Student::getSurname, st -> st));
    }

    public List<Student> levelOf(List<Student> students, int bound) {
        return students.stream()
                .flatMap(Stream::ofNullable)
                .sorted()
                .filter(student -> student.getScore() > bound)
                .collect(Collectors.toList());
    }
}
