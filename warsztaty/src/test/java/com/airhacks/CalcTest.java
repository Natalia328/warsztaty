package com.airhacks;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CalcTest {
    @Test
    public void testSum() {
        Calculator calculator = new Calculator();
        int a = 5;
        int b= 6;
        int resultExpected = 11;
        Assert.assertEquals(resultExpected, calculator.sum(a,b));
    }


}
