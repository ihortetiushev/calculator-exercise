package com.epam.tat.module4.calculator;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static java.lang.Math.*;

public class CtgTest {
    @DataProvider(name = "ctgDoubleData")
    public Object[][] provideDoubleCtgData() {
        Calculator calculator = new Calculator();
        return new Object[][] {
                {calculator, toRadians(30), sqrt(3)},
                {calculator, toRadians(45), 1},
                {calculator, toRadians(60), 1 / sqrt(3)},
                {calculator, toRadians(90), 0},
                {calculator, toRadians(270), 0}
        };
    }
    @Test(dataProvider = "ctgDoubleData")
    public void ctgDoubleTest(Calculator calculator, double a, double expected) {
        double result = calculator.ctg(a);
        Assert.assertEquals(result, expected, 0.0001,"Test ctg function with double type");
    }
}


