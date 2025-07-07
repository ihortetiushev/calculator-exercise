package com.epam.tat.module4.calculator;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SubtractionTest {
    @DataProvider(name = "subLongData")
    public static Object[][] provideLongSubData() {
        Calculator calculator = new Calculator();
        return new Object[][]{
                {calculator, 12L, 1L, 11L},
                {calculator, 0L, 0L, 0L},
                {calculator, -10L, -5L, -5L},
                {calculator, -5L, 10L, -15L},
                {calculator, 1000000L, 1L, 999999L},
                {calculator, Long.MAX_VALUE, 1L, Long.MAX_VALUE - 1},
                {calculator, Long.MIN_VALUE, -1L, Long.MIN_VALUE + 1},
        };
    }

    @DataProvider(name = "subDoubleData")
    public Object[][] provideDoubleSubData() {
        Calculator calculator = new Calculator();
        return new Object[][]{
                {calculator, 12.1, 2.3, 9.8},
                {calculator, 3.5, 2.5, 1.0},
                {calculator, -11.7, 7.8, -19.5},
                {calculator, 0.0, 0.0, 0.0},
                {calculator, 100.53, 90.21, 10.32},
                {calculator, -5.46, 11.25, -16.71},
                {calculator, -110.8, -9.2, -101.6},
        };
    }

    @Test(dataProvider = "subDoubleData")
    public void subDoubleTest(Calculator calculator, double a, double b, double expected) {
        double result = calculator.sub(a, b);
        Assert.assertEquals(result, expected, 0.001,
                String.format("Expected value %.2f is different from actual %.2f value", expected, result));
    }

    @Test(dataProvider = "subLongData")
    public void subLongTest(Calculator calculator, long a, long b, long expected) {
        long result = calculator.sub(a, b);
        Assert.assertEquals(result, expected,
                String.format("Expected value %d is different from actual %d value", expected, result));
    }
}