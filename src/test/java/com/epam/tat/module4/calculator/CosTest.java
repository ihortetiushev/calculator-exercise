package com.epam.tat.module4.calculator;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static java.lang.Math.toRadians;

public class CosTest {
    @DataProvider(name = "cosDoubleData")
    public Object[][] provideDoubleCosData() {
        Calculator calculator = new Calculator();
        return new Object[][] {
                {calculator, toRadians(0.0), 1.0},
                {calculator, toRadians(60.0), 0.5},
                {calculator, toRadians(90), 0.0},
                {calculator, toRadians(180), -1.0}
        };
    }
    @Test(dataProvider = "cosDoubleData")
    public void cosDoubleTest(Calculator calculator, double a, double expected) {
        double result = calculator.cos(a);
        Assert.assertEquals(result, expected,0.0001, "Test cos function with double type");
    }
}
