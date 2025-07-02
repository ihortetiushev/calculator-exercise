package com.epam.tat.module4.calculator;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PowTest {
    @DataProvider(name = "powDoubleData")
    public Object[][] provideDoublePowData() {
        Calculator calculator = new Calculator();
        return new Object[][] {
                {calculator, 2.0, 3.0, 8.0},
                {calculator, 2.0, 3.7, 8.0},
                {calculator, 2.0, -2.0, 0.25},
                {calculator, 5.0, 0.0, 1.0},
                {calculator, 0.0, 5.0, 0.0},
                {calculator, -2.0, 3.0, -8.0},
                {calculator, -2.0, 4.0, 16.0},
                {calculator, 0.0, 0.0, 1.0},
                {calculator, 0.0, -1.0, Double.POSITIVE_INFINITY}
        };
    }
    @Test(dataProvider = "powDoubleData")
    public void powDoubleTest(Calculator calculator, double a, double b, double expected) {
        double result = calculator.pow(a, b);
        Assert.assertEquals(result, expected, "Test pow function with double type");
    }
}
