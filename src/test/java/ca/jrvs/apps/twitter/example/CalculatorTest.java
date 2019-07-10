package ca.jrvs.apps.twitter.example;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {

    private Calculator calculator;
    @Before
    public void setup(){
        calculator = new Calculator();
    }

    @Test
    public void evaluateHappyPath(){
        System.out.println("hello world, This is my first Junit Test");
        Calculator calculator = new Calculator();
        int sum = calculator.evaluate("1+7");
        System.out.println(sum);

    }

    @Test
    public void evaluateSadPath(){
        System.out.println("hello world, This is my first Junit Test");
        Calculator calculator = new Calculator();
        int sum = calculator.evaluate("1.1+7");
        System.out.println(sum);
    }
}