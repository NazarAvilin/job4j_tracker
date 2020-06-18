package ru.job4j.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class MatrixToList {
    public static List<Integer> arrayToList(Integer[][] array2d) {
        return Stream.of(array2d)
                .flatMap(Arrays::stream)
                .collect(Collectors.toList());
    }
}
