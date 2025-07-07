package com.epam.tat.module4.calculator;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static java.lang.Math.toRadians;

public class CosineTest {
    @DataProvider(name = "cosDoubleData")
    public Object[][] provideDoubleCosData() {
        Calculator calculator = new Calculator();
        return new Object[][]{
                {calculator, toRadians(0.0), 1.0},
                {calculator, toRadians(60.0), 0.5},
                {calculator, toRadians(75.9), 0.87},
                {calculator, toRadians(90), 0.0},
                {calculator, toRadians(150.5), 0.95},
                {calculator, toRadians(180), -1.0}
        };
    }

    @Test(dataProvider = "cosDoubleData")
    public void cosDoubleTest(Calculator calculator, double a, double expected) {
        double result = calculator.cos(a);
        Assert.assertEquals(result, expected, 0.001,
                String.format("Expected value %.2f is different from actual %.2f value", expected, result));
    }
}