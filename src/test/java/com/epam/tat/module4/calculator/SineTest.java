package com.epam.tat.module4.calculator;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static java.lang.Math.*;

public class SineTest {
    @DataProvider(name = "sinDoubleData")
    public Object[][] provideDoubleSinData() {
        Calculator calculator = new Calculator();
        return new Object[][]{
                {calculator, toRadians(0.0), 0.0},
                {calculator, toRadians(60.0), sqrt(3) / 2},
                {calculator, toRadians(90.0), 1.0},
                {calculator, toRadians(180.0), 0.0},
                {calculator, toRadians(360.0), 0.0}
        };
    }

    @Test(dataProvider = "sinDoubleData")
    public void sinDoubleTest(Calculator calculator, double a, double expected) {
        double result = calculator.sin(a);
        Assert.assertEquals(result, expected, 0.0001, "Test sin function with double type");
    }
}