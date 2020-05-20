package com.example.lesson1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MyUnitTest {

    private Converter converter;

    @Before
    public void before() {
        converter = new Converter(36);
    }

    @Test
    public void toConvertIsCorrect() {
        double result = converter.toConvert();
        Assert.assertEquals(result, 10, 0.01);
    }

    @Test
    public void toConvertIsIncorrect() {
        double result = converter.toConvert();
        Assert.assertNotEquals(result, 10.02, 0.01);
    }
}
