package com.in28minutes;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ListTest {
    List<String> list = mock(List.class);

    @Test
    public void letsMockListSize() {
        when(list.size()).thenReturn(10);
        assertEquals(10, list.size());
    }

    @Test
    public void letsMockListSizeWithMultipleReturnValues() {
        when(list.size()).thenReturn(10).thenReturn(20);
        assertEquals(10, list.size());//first call
        assertEquals(20, list.size());//second call
    }

    @Test
    public void letsMockListGet() {
        when(list.get(0)).thenReturn("in28minutes");
        assertEquals("in28minutes", list.get(0));
        assertNull(list.get(2));
    }

    @Test
    public void letsMockListGetWithAny() {
        when(list.get(anyInt())).thenReturn("in28minutes");
        assertEquals("in28minutes", list.get(new Random().nextInt(10)));
    }

    @Test
    public void letsMockList_throwAnException() {
        when(list.get(anyInt())).thenThrow(new RuntimeException("Some Exception"));
        var exception = assertThrows(RuntimeException.class, () -> {
            list.get(0);
        });
        assertEquals("Some Exception", exception.getMessage());
    }

    @Test
    public void letsMockList_mixingUpMatcherWithHardcoded() {
        var exception = assertThrows(RuntimeException.class, () -> {
            list.subList(anyInt(), 5);
        });
        System.out.println(exception.getMessage());
        assertTrue(exception.getMessage().contains("Invalid use of argument matchers!"));
    }

    @Test
    public void letsMockListGetUsingBDD() {
        //given
        given(list.get(0)).willReturn("in28minutes");
        //when
        var actualValue = list.get(0);
        //then
        assertEquals("in28minutes", actualValue);
        assertNull(list.get(2));
    }
}
