package com.deborawendland.calculatorDocker.annotation;

import com.deborawendland.calculatorDocker.operation.*;
import com.deborawendland.calculatorDocker.service.Calculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan(basePackages =  "com.deborawendland.cloud.tema01.annotation")
public class AppConfig {

    @Bean
    @Scope("prototype")
    public Division division(){
        return new Division();
    }

    @Bean
    @Scope("prototype")
    public Exponentiation exponentiation(){
        return new Exponentiation();
    }

    @Bean
    @Scope("prototype")
    public Multiplication multiplication(){
        return new Multiplication();
    }

    @Bean
    @Scope("prototype")
    public Summation summation(){
        return new Summation();
    }

    @Bean
    @Scope("prototype")
    public Subtraction subtraction(){
        return new Subtraction();
    }

    @Bean
    public Calculator calculator() {
        return new Calculator();
    }
}