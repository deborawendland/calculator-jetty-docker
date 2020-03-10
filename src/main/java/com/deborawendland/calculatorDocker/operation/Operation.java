package com.deborawendland.calculatorDocker.operation;

public interface Operation extends Cloneable {

    double doOperation();
    void addFirstTerm(double firstTerm);
    void addSecondTerm(double secondTerm);
    double getFirstTerm();
    double getSecondTerm();
    String toString();
}
