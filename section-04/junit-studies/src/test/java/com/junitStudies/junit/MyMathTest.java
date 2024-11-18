package com.junitStudies.junit;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyMathTest {

    @Test
    public void calculateSum() {
        int [] numbers = {1,2,3};
        MyMath math = new MyMath();
        int result = math.calculateSum(numbers);
        assertEquals(6,result);
    }
}