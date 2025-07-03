package com.epam.tat.module4.calculator;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static java.lang.Math.*;

public class TangentTest {
    @DataProvider(name = "tgDoubleData")
    public Object[][] provideDoublePowData() {
        Calculator calculator = new Calculator();
        return new Object[][]{
                {calculator, toRadians(0.0), 0.0},
                {calculator, toRadians(30.0), (sqrt(3)) / 3},
                {calculator, toRadians(45.0), 1.0},
                {calculator, toRadians(60), sqrt(3)}
        };
    }

    @Test(dataProvider = "tgDoubleData")
    public void tgDoubleTest(Calculator calculator, double a, double expected) {
        double result = calculator.tg(a);
        Assert.assertEquals(result, expected, 0.0001, "Test tg function with double type");
    }
}