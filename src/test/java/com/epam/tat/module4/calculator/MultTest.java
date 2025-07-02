package com.epam.tat.module4.calculator;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MultTest {
    @DataProvider(name = "multDoubleData")
    public Object[][] provideDoubleMultData() {
        Calculator calculator = new Calculator();
        return new Object[][] {
                {calculator, 0.0, 0.0, 0.0},
                {calculator, 5.5, 0.0, 0.0},
                {calculator, 2.5, 2.0, 5.0},
                {calculator, 2.5, 2.1, 5.25},
                {calculator, -3.5, 2.0, -7.0},
                {calculator, -2.5, -2.5, 6.25},
                {calculator, 1.5, 3.0, 4.5},
                {calculator, 10.0, 0.5, 5.0}
        };
    }
    @DataProvider(name = "multLongData")
    public static Object[][] provideLongMultData() {
        Calculator calculator = new Calculator();
        return new Object[][] {
                {calculator, 0L, 0L, 0L},
                {calculator, 5L, 0L, 0L},
                {calculator, -5L, 2L, -10L},
                {calculator, -5L, -2L, 10L},
                {calculator, 12345L, 1L, 12345L},
                {calculator, Long.MAX_VALUE, 1L, Long.MAX_VALUE},
                {calculator, 1000000L, 1000L, 1_000_000_000L}
        };
    }
    @Test(dataProvider = "multDoubleData")
    public void multDoubleTest(Calculator calculator, double a, double b, double expected) {
        double result = calculator.mult(a, b);
        Assert.assertEquals(result, expected, "Test mult function with double type");
    }
    @Test(dataProvider = "multLongData")
    public void multLongTest(Calculator calculator, long a, long b, long expected) {
        long result = calculator.mult(a, b);
        Assert.assertEquals(result, expected, "Test mult function with long type");
    }
}
