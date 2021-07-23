package co.com.sofka.app;

import co.com.sofka.app.calculator.BasicCalculator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {

    private static final Logger logger = LoggerFactory.getLogger( App.class );

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader( new InputStreamReader( System.in ) );

        System.out.println( "Enter number 1: " );
        String textNumber1 = bufferedReader.readLine();

        System.out.println( "Enter number 2: " );
        String textNumber2 = bufferedReader.readLine();

        Double number1 = Double.valueOf( textNumber1 );
        Double number2 = Double.valueOf( textNumber2 );

        BasicCalculator calculator = new BasicCalculator();

        Double resultSum = calculator.sum( number1, number2 );
        Double resultRest = calculator.res( number1, number2 );
        Double resultMult = calculator.mult( number1, number2 );
        Double resultDiv = calculator.div( number1, number2 );

        System.out.println( number1 + " + " + number2 + " = " + resultSum );
        System.out.println( number1 + " - " + number2 + " = " + resultRest );
        System.out.println( number1 + " * " + number2 + " = " + resultMult );
        System.out.println( number1 + " / " + number2 + " = " + resultDiv );
    }
}


