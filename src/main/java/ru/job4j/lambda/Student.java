package ru.job4j.lambda;

import java.util.Objects;

public final class Student {
    private String surname;
    private int score;

    public Student(final String surname, final int score) {
        this.surname = surname;
        this.score = score;
    }

    public String getSurname() {
        return this.surname;
    }

    public int getScore() {
        return this.score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Student student = (Student) o;
        return score == student.score
                &&  surname.equals(student.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(score, surname);
    }
}