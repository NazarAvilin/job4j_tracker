package ru.job4j.lambda;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MatrixToListTest {

    @Test
    public void whenArray2DtoList() {
        Integer[][] array = {{1, 2}, {3, 4}};
        List<Integer> expected = List.of(1, 2, 3, 4);
        List<Integer> result = MatrixToList.arrayToList(array);
        assertThat(result, is(expected));
    }
}