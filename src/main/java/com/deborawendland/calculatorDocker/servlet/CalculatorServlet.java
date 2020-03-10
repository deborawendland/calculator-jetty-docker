package com.deborawendland.calculatorDocker.servlet;

import com.deborawendland.calculatorDocker.annotation.AppConfig;
import com.deborawendland.calculatorDocker.operation.*;
import com.deborawendland.calculatorDocker.service.Calculator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        description = "Calculator Servlet",
        urlPatterns = {"/calculatorServlet"}
)
public class CalculatorServlet extends HttpServlet {

    private PrintWriter printWriter;
    private ApplicationContext applicationContext;
    private Calculator calculator;

    public CalculatorServlet(){
        applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        calculator = (Calculator) applicationContext.getBean("calculator");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        printWriter = response.getWriter();

        if (request.getParameterMap().containsKey("logs")){
            printWriter.println("Calculation Logs: ");
            calculator.getOperationsLog()
                    .stream()
                    .forEach(operation -> printWriter.println("<br>" + operation.toString()));
        } else if (request.getParameterMap().containsKey("firstTerm")
                && request.getParameterMap().containsKey("secondTerm")){
                double firstTerm = Double.parseDouble(request.getParameter("firstTerm"));
                double secondTerm = Double.parseDouble(request.getParameter("secondTerm"));
                double result = 0;
                switch (request.getParameter("op")){
                    case ("sum"):
                        Summation summation = (Summation) applicationContext.getBean("summation");
                        result = calculator.doOperation(summation, firstTerm, secondTerm);
                        break;
                    case ("sub"):
                        Subtraction subtraction = (Subtraction) applicationContext.getBean("subtraction");
                        result = calculator.doOperation(subtraction, firstTerm, secondTerm);
                        break;
                    case ("mul"):
                        Multiplication multiplication = (Multiplication) applicationContext.getBean("multiplication");
                        result = calculator.doOperation(multiplication, firstTerm, secondTerm);
                        break;
                    case ("div"):
                        Division division = (Division) applicationContext.getBean("division");
                        result = calculator.doOperation(division, firstTerm, secondTerm);
                        break;
                    case ("exp"):
                        Exponentiation exponentiation = (Exponentiation) applicationContext.getBean("exponentiation");
                        result = calculator.doOperation(exponentiation, firstTerm, secondTerm);
                        break;
                }
            printWriter.println("Result: " + result);
        }
    }
}
