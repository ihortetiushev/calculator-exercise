package com.epam.tat.module4.calculator;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class IsNegativeTest {
    @DataProvider(name = "isNegativeData")
    public static Object[][] providePositiveNegativeData() {
        Calculator calculator = new Calculator();
        return new Object[][]{
                {calculator, 1, false},
                {calculator, 0, false},
                {calculator, Long.MAX_VALUE, false},
                {calculator, Long.MIN_VALUE, true},
                {calculator, -1, true}
        };
    }

    @Test(dataProvider = "isNegativeData")
    public void isNegativeTest(Calculator calculator, long a, boolean expected) {
        boolean result = calculator.isNegative(a);
        Assert.assertEquals(result, expected, "Test isNegative function with double type");
    }
}