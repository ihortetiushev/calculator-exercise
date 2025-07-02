package com.epam.tat.module4.calculator;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SqrtTest {
    @DataProvider(name = "sqrtDoubleData")
    public Object[][] provideDoubleSqrtData() {
        Calculator calculator = new Calculator();
        return new Object[][] {
                {calculator, 81.0, 9.0},
                {calculator, 9.0, 3.0},
                {calculator, 0.0, 0.0},
                {calculator, 144.0, 12.0}
        };
    }
    @Test(dataProvider = "sqrtDoubleData")
    public void tgDoubleTest(Calculator calculator, double a, double expected) {
        double result = calculator.sqrt(a);
        Assert.assertEquals(result, expected, 0.0001, "Test sqrt function with double type");
    }
}

