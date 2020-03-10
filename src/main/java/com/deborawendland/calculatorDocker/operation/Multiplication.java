package com.deborawendland.calculatorDocker.operation;

import org.springframework.beans.factory.annotation.Autowired;

public class Multiplication implements Operation {

    private double firstFactor;
    private double secondFactor;

    @Autowired
    public Multiplication() {
    }

    @Override
    public double doOperation() {
        return firstFactor * secondFactor;
    }

    @Override
    public void addFirstTerm(double firstTerm) {
        this.firstFactor = firstTerm;
    }

    @Override
    public void addSecondTerm(double secondTerm) {
        this.secondFactor = secondTerm;
    }

    @Override
    public double getFirstTerm() {
        return this.firstFactor;
    }

    @Override
    public double getSecondTerm() {
        return this.secondFactor;
    }

    @Override
    public String toString(){
        return "Operation: " + this.getClass().getSimpleName() +
                " - First Factor: " + this.firstFactor +
                " - Second Factor: " + this.secondFactor;
    }
}
