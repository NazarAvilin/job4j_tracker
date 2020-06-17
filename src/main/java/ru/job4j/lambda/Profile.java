package ru.job4j.lambda;

public final class Profile {
    private Address address;

    public Profile(final Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }
}