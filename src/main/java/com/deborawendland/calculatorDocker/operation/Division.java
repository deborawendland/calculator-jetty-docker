package com.deborawendland.calculatorDocker.operation;

import org.springframework.beans.factory.annotation.Autowired;

public class Division implements Operation {

    private double numerator;
    private double denominator;

    @Autowired
    public Division() {
    }

    @Override
    public double doOperation() {
        if (denominator != 0){
            return numerator/denominator;
        } else {
            throw new IllegalArgumentException("Invalid Operation: dividing by 0");
        }
    }

    @Override
    public void addFirstTerm(double firstTerm) {
        this.numerator = firstTerm;
    }

    @Override
    public void addSecondTerm(double secondTerm) {
        this.denominator = secondTerm;
    }

    @Override
    public double getFirstTerm() {
        return this.numerator;
    }

    @Override
    public double getSecondTerm() {
        return this.denominator;
    }

    @Override
    public String toString(){
        return "Operation: " + this.getClass().getSimpleName() +
                " - Numerator: " + this.numerator +
                " - Denominator: " + this.denominator;
    }

}
