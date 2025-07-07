package com.epam.tat.module4.calculator;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DivisionTest {
    @DataProvider(name = "divLongData")
    public static Object[][] provideLongDivData() {
        Calculator calculator = new Calculator();
        return new Object[][]{
                {calculator, 10L, 2L, 5L},
                {calculator, 8L, 4L, 2L},
                {calculator, -10L, 2L, -5L},
                {calculator, -10L, -2L, 5L},
                {calculator, 0L, 5L, 0L},
                {calculator, Long.MAX_VALUE, 1L, Long.MAX_VALUE}
        };
    }

    @DataProvider(name = "divDoubleData")
    public Object[][] provideDoubleDivData() {
        Calculator calculator = new Calculator();
        return new Object[][]{
                {calculator, 10.0, 2.0, 5.0},
                {calculator, 9.0, 4.0, 2.25},
                {calculator, -10.0, 2.0, -5.0},
                {calculator, -10.0, -2.0, 5.0},
                {calculator, 0.0, 5.0, 0.0},
                {calculator, 10.0, 0.0, Double.POSITIVE_INFINITY},
                {calculator, -10.0, 0.0, Double.NEGATIVE_INFINITY},
                {calculator, 0.0, 0.0, Double.NaN}
        };
    }

    @Test(dataProvider = "divDoubleData")
    public void divDoubleTest(Calculator calculator, double a, double b, double expected) {
        double result = calculator.div(a, b);
        Assert.assertEquals(result, expected, 0.001,
                String.format("Expected value %.2f is different from actual %.2f value", expected, result));
    }

    @Test(dataProvider = "divLongData")
    public void divLongTest(Calculator calculator, long a, long b, long expected) {
        long result = calculator.div(a, b);
        Assert.assertEquals(result, expected,
                String.format("Expected value %d is different from actual %d value", expected, result));
        try {
            calculator.div(a, 0);
            Assert.fail("Expected NumberFormatException when dividing by zero");
        } catch (NumberFormatException e) {
            Assert.assertTrue(e.getMessage().contains("divide by zero"),
                    "Exception message should contain 'divide by zero'");
        }
    }
}