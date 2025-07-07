package com.epam.tat.module4.calculator;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SquareTest {
    @DataProvider(name = "sqrtDoubleData")
    public Object[][] provideDoubleSqrtData() {
        Calculator calculator = new Calculator();
        return new Object[][]{
                {calculator, 81.0, 9.0},
                {calculator, 9.5, 3.082207001484488},
                {calculator, 0.0, 0.0},
                {calculator, 144.0, 12.0},
                {calculator, 156.8, 12.521},
                {calculator, 19.3, 4.393},
                {calculator, 25.6, 5.059},
        };
    }

    @Test(dataProvider = "sqrtDoubleData")
    public void tgDoubleTest(Calculator calculator, double a, double expected) {
        double result = calculator.sqrt(a);
        Assert.assertEquals(result, expected, 0.001,
                String.format("Expected value %.2f is different from actual %.2f value", expected, result));
    }
}