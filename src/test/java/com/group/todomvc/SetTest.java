package com.group.todomvc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    // Test Case 구현
    @Test
    void test() {
        assertThat(numbers.size() == 3);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void contains(int N) {
//        assertThat(numbers.contains(N)).isTrue();
        Assertions.assertTrue(numbers.contains(N));
    }

}