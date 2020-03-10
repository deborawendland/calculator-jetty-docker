package com.deborawendland.calculatorDocker.service;

import com.deborawendland.calculatorDocker.annotation.AppConfig;
import com.deborawendland.calculatorDocker.operation.*;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class CalculatorTest {

    @Autowired
    private Calculator calculator;
    @Autowired
    private Multiplication multiplication;
    @Autowired
    private Division division;
    @Autowired
    private Summation summation;
    @Autowired
    private Subtraction subtraction;
    @Autowired
    private Exponentiation exponentiation;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void pathTest(){
        Assert.assertNotNull(calculator);
    }

    @Test
    public void doOperationSummationTest() {
        Assert.assertTrue(calculator.doOperation(summation, -9, 8) == -1);
    }

    @Test
    public void doOperationSubtractionTest() {
        Assert.assertTrue(calculator.doOperation(subtraction, 8,-2) == 10);
    }

    @Test
    public void doOperationMultiplicationTest() {
        Assert.assertTrue(calculator.doOperation(multiplication, 8,-2) == -16);
    }

    @Test
    public void doOperationExponentiationTest() {
        Assert.assertTrue(calculator.doOperation(exponentiation, 2,3) == 8);
    }

    @Test
    public void doOperationValidDivisionTest() {
        Assert.assertTrue(calculator.doOperation(division, 5,2) == 2.5);
    }

    @Test
    public void doOperationInvalidDivisionTest() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Invalid Operation: dividing by 0");
        calculator.doOperation(division, 5,0);
    }

    @Test
    public void operationsLogTest(){
        calculator.getOperationsLog().clear();
        calculator.doOperation(exponentiation, 2,3);
        calculator.doOperation(multiplication, 8,-2);
        calculator.doOperation(multiplication, 8,-2);

        Assert.assertTrue(calculator.getOperationsLog().size() == 3);

        Assert.assertTrue(calculator.getOperationsLog().get(0).getFirstTerm() == 2);
        Assert.assertTrue(calculator.getOperationsLog().get(0).getSecondTerm() == 3);
        Assert.assertTrue(calculator.getOperationsLog().get(0) instanceof Exponentiation);

        Assert.assertTrue(calculator.getOperationsLog().get(1).getFirstTerm() == 8);
        Assert.assertTrue(calculator.getOperationsLog().get(1).getSecondTerm() == -2);
        Assert.assertTrue(calculator.getOperationsLog().get(1) instanceof Multiplication);

        Assert.assertTrue(calculator.getOperationsLog().get(2).getFirstTerm() == 8);
        Assert.assertTrue(calculator.getOperationsLog().get(2).getSecondTerm() == -2);
        Assert.assertTrue(calculator.getOperationsLog().get(2) instanceof Multiplication);
    }
}