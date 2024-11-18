package com.junitStudies.junit;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyMathTest {
    private MyMath math = new MyMath();

    @Test
    public void calculateSum_ThreeMemberArray() {
        assertEquals(math.calculateSum(new int[] {1,2,3}),6);
    }

    @Test
    public void calculateSum_ZeroLengthArray() {
        assertEquals(math.calculateSum(new int[]{}),0);
    }

}