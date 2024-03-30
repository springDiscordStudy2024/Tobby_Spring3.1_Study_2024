package com.group.todomvc;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    @DisplayName("1과 2로 잘 분리되는지 확인")
    void splitMany() {
        String task = "1,2";
        String[] answer = task.split(",");
        assertThat(answer).contains("1");
    }

    @Test
    @DisplayName("1만을 포함하는 배열")
    void splitOne() {
        String task = "1";
        String[] answer = task.split(",");
        assertThat(answer).containsExactly("1");
    }

    @Test
    @DisplayName("substring() 메소드를 활용")
    void substring() {
        String s = "(1,2)";
        assertEquals("1,2", s.substring(1, s.length() - 1));
    }

    @Test
    @DisplayName("charAt() 메소드를 활용, IndexOutOfBoundsException")
    void StringIndexOutOfBoundsException() {
        String str = "abc";

        assertThatThrownBy(() -> {
            str.charAt(6);
        })
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessage("error");
    }


}
