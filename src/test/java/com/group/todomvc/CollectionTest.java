package com.group.todomvc;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CollectionTest {
    @Test
    public void arrayList() {
        ArrayList<String> v = new ArrayList<>();
        v.add("1");
        v.add("2");
        assertThat(v.add("3")).isTrue();
        assertThat(v.size()).isEqualTo("3");
        assertThat(v.get(0)).isEqualTo("1");
        assertThat(v.contains("1")).isTrue();
        assertThat(v.remove(0)).isEqualTo("1");
        assertThat(v.size()).isEqualTo("2");
    }
}
