package com.epam.tat.module4.calculator;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MultiplicationTest {
    @DataProvider(name = "multDoubleData")
    public Object[][] provideDoubleMultData() {
        Calculator calculator = new Calculator();
        return new Object[][]{
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
    public Object[][] provideLongMultData() {
        Calculator calculator = new Calculator();
        return new Object[][]{
                {calculator, 0, 0, 0},
                {calculator, 3, 5, 15},
                {calculator, 1, 2, 2},
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