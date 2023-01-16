package com.in28minutes;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class ListTestWithHemcrest {
    List<String> list = mock(List.class);

    @Test
    public void letsMockListSize() {
        when(list.size()).thenReturn(10);
        assertEquals(10, list.size());
        var v = hasSize(10);
        //assertThat(10, hasSize(10));
        assertThat(10, is(10));//"is" is coming from CoreMatcher
    }

    @Test
    public void letsMockListSizeWithMultipleReturnValues() {
        when(list.size()).thenReturn(10).thenReturn(20);
        assertThat(10, is(10));
        assertThat(20, is(20));
    }

    @Test
    public void testHamcrestList() {
        var listOfInt = List.of(10, 20, 30, 40);
        assertThat(listOfInt, hasSize(4));
        assertThat(listOfInt, hasItems(10, 20, 30, 40));
        assertThat(listOfInt, everyItem(greaterThan(5)));
        assertThat(listOfInt, everyItem(lessThan(50)));
    }

    @Test
    public void testString() {
        assertThat("", isEmptyOrNullString());
        assertThat(null, isEmptyOrNullString());
    }
}
