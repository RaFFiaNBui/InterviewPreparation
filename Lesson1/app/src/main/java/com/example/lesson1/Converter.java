package com.example.lesson1;

public class Converter {

    private double value;

    public Converter(double value) {
        this.value = value;
    }

    public double toConvert() {
        double scale = Math.pow(10, 2);
        double result = value * 10 / 36;
        return Math.round(result * scale) / scale;
    }
}
