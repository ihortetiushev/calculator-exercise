package com.epam.tat.module4.calculator;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class IsPositiveTest {
    @DataProvider(name = "isPositiveData")
    public static Object[][] providePositiveData() {
        Calculator calculator = new Calculator();
        return new Object[][]{
                {calculator, 1, true},
                {calculator, 0, false},
                {calculator, Long.MAX_VALUE, true},
                {calculator, Long.MIN_VALUE, false},
                {calculator, 100000000, true},
                {calculator, -1000000001, false},
                {calculator, -1, false}
        };
    }

    @Test(dataProvider = "isPositiveData")
    public void isPositiveTest(Calculator calculator, long a, boolean expected) {
        boolean result = calculator.isPositive(a);
        Assert.assertEquals(result, expected,
                String.format("Expected isPositive %d to be %b but was %b", a, expected, result));
    }
}