package com.epam.tat.module4.calculator;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SumTest {
    @DataProvider(name = "doubleSumData")
    public static Object[][] provideDoubleSumData() {
        Calculator calculator = new Calculator();
        return new Object[][] {
                {calculator, 5.0, 3.0, 8.0},
                {calculator, 6.5, 2.5, 9.0},
                {calculator, -2.0, 1.0, -1.0},
                {calculator, Long.MAX_VALUE, 0L, Long.MAX_VALUE},
                {calculator, Long.MAX_VALUE - 1, 1L, Long.MAX_VALUE},
                {calculator, Long.MIN_VALUE, 1L, Long.MIN_VALUE + 1}
        };
    }

    @DataProvider(name = "longSumData")
    public static Object[][] provideLongSumData() {
        Calculator calculator = new Calculator();
        return new Object[][] {
                {calculator, 0L, 0L, 0L},
                {calculator, 5L, 10L, 15L},
                {calculator, -5L, 10L, 5L},
                {calculator, -20L, -30L, -50L},
        };
    }
    @Test(dataProvider = "doubleSumData")
    public void sumDoubleTest(Calculator calculator, double a, double b, double expected) {
        double result = calculator.sum(a, b);
        Assert.assertEquals(result, expected, "Test sum function with double type");
    }
    @Test(dataProvider = "longSumData")
    public void sumLongTest(Calculator calculator, long a, long b, long expected) {
        long result = calculator.sum(a, b);
        Assert.assertEquals(result, expected, "Test sum function with long type");
    }
}
