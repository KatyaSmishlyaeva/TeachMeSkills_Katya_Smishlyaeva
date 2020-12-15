package com.teachmeskills.homework7.calculator.operations;

public class Addition extends Operations {

    @Override
    public Object calculations(Object firstValue, Object secondValue) {
        result = (double) firstValue + (double) secondValue;
        return result;
    }
}
