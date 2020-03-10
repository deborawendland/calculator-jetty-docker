package com.deborawendland.calculatorDocker.operation;

import org.springframework.beans.factory.annotation.Autowired;

public class Exponentiation implements Operation {

    private double base;
    private double exponent;

    @Autowired
    public Exponentiation() {
    }

    @Override
    public double doOperation() {
        return Math.pow(base, exponent);
    }

    @Override
    public void addFirstTerm(double firstTerm) {
        this.base = firstTerm;
    }

    @Override
    public void addSecondTerm(double secondTerm) {
        this.exponent = secondTerm;
    }

    @Override
    public double getFirstTerm() {
        return this.base;
    }

    @Override
    public double getSecondTerm() {
        return this.exponent;
    }

    @Override
    public String toString(){
        return "Operation: " + this.getClass().getSimpleName() +
                " - Base: " + this.base +
                " - Exponent: " + this.exponent;
    }

}
