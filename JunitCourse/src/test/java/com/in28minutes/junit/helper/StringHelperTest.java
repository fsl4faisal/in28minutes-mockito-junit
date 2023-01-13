package com.in28minutes.junit.helper;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StringHelperTest {

    @Test
    void truncateAInFirst2Positions() {
    }

    @Test
    void areFirstAndLastTwoCharactersTheSame() {
    }

    /*
    Below is how Junit 4 uses assert Exceptions

    @Test(expected = NullPointerException.class)
    public void testArraySort_NullArray() {
        int[] numbers = null;
        Arrays.sort(numbers);
    }
    */

    /*
    Below is how Junit 5 asserts Exceptions
     */

    @Test
    public void testArraySort_NullArray() {
        var exception = assertThrows(RuntimeException.class, () -> {
            int[] numbers = null;
            Arrays.sort(numbers);
        });
        var expected = "Cannot read the array length";
        var actual = exception.getMessage();
        System.out.println(actual);
        assertTrue(actual.contains(expected));
    }

    /*
    Below is how we used to do performance testing in Junit 4

    @Test(timeout = 100)
    public void testSort_Performance() {
        var arr = new int[]{12, 14, 34};
        for (int i = 0; i < 1_000_000; i++) {
            arr[0] = i;
            Arrays.sort(arr);
        }
    }
    */

    /*
    More on this link
    https://stackoverflow.com/questions/57116801/how-to-fail-a-test-after-a-timeout-is-exceeded-in-junit-5#:~:text=assertTimeout()%20and%20Assertions.,the%20Supplier%20passed%20as%20parameter.
     */
    @Timeout(value = 100_000, unit = TimeUnit.MICROSECONDS)
    @Test
    public void testSort_Performance() {
        var arr = new int[]{12, 14, 34};
        for (int i = 0; i < 1_000_000; i++) {
            arr[0] = i;
            Arrays.sort(arr);
        }
    }

}