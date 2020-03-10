package com.deborawendland.calculatorDocker.service;

import com.deborawendland.calculatorDocker.operation.Operation;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    private List<Operation> operationsLog;

    public Calculator(){
        this.operationsLog = new ArrayList();
    }

    public double doOperation(Operation operation, double firstTerm, double secondTerm){
        operation.addFirstTerm(firstTerm);
        operation.addSecondTerm(secondTerm);
        operationsLog.add(operation);
        return operation.doOperation();
    }

    public List<Operation> getOperationsLog() {
        return operationsLog;
    }
}
