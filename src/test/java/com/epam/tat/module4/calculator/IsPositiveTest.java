package com.epam.tat.module4.calculator;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class IsPositiveTest {
    @DataProvider(name = "isPositiveData")
    public static Object[][] providePositiveData() {
        Calculator calculator = new Calculator();
        return new Object[][] {
                {calculator, 1, true},
                {calculator, 0, false},
                {calculator, Long.MAX_VALUE, true},
                {calculator, Long.MIN_VALUE, false},
                {calculator, -1, false}
        };
    }
    @Test(dataProvider = "isPositiveData")
    public void isPositiveTest(Calculator calculator, long a, boolean expected) {
        boolean result = calculator.isPositive(a);
        Assert.assertEquals(result, expected, "Test isPositive function with double type");
    }
}
