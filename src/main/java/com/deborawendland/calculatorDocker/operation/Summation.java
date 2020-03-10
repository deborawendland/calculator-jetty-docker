package com.deborawendland.calculatorDocker.operation;

import org.springframework.beans.factory.annotation.Autowired;

public class Summation implements Operation {

    private double firstTerm;
    private double secondTerm;

    @Autowired
    public Summation() {

    }

    @Override
    public double doOperation(){
        return firstTerm + secondTerm;
    }

    @Override
    public void addFirstTerm(double firstTerm) {
        this.firstTerm = firstTerm;
    }

    @Override
    public void addSecondTerm(double secondTerm) {
        this.secondTerm = secondTerm;
    }

    @Override
    public double getFirstTerm() {
        return this.firstTerm;
    }

    @Override
    public double getSecondTerm() {
        return this.secondTerm;
    }

    @Override
    public String toString(){
        return "Operation: " + this.getClass().getSimpleName() +
                " - First Term: " + this.firstTerm +
                " - Second Term: " + this.secondTerm;
    }
}
