package ru.job4j.collection;

import java.util.Objects;

public class User implements Comparable<User> {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(User user) {
        int client = name.compareTo(user.getName());
        if (client == 0) {
            client = Integer.compare(this.age, user.getAge());
        }
        return client;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return age == user.getAge() && Objects.equals(name, user.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}