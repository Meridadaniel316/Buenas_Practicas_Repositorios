package co.com.sofka.app.calculator;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BasicCalculatorTest {
    private final BasicCalculator basicCalculator = new BasicCalculator();

    @Test
    @DisplayName("Testing sum: 1+1=2")
    public void sum() {
        // Arrange
        Double number1 = Double.valueOf(1L);
        Double number2 = Double.valueOf(1L);
        Double expectedValue = Double.valueOf(2L);

        // Act
        Double result = basicCalculator.sum( number1,number2 );
        // Assert
        assertEquals(expectedValue, result);
    }

    //Sumation case
    @DisplayName("Testing several sums")
    @ParameterizedTest(name = "{0} + {1} = {2}")
    @CsvSource({
            "0,   1,   1",
            "1,   2,   3",
            "49,  51, 100",
            "1,  100, 101"
    })
    public void severalSums(Double first, Double second, Double expectedResult) {
        assertEquals(expectedResult, basicCalculator.sum(first, second),
                () -> first + " + " + second + " should equal " + expectedResult);
    }

    //Subtraction case
    @DisplayName("Testing several substraction case")
    @ParameterizedTest(name = "{0} - {1} = {2}")
    @CsvSource({
            "1,   0,   1",
            "1,   2,  -1",
            "51,  49, 2",
            "100,  1, 99"
    })
    public void severalres(Double first, Double second, Double expectedResult) {
        assertEquals(expectedResult, basicCalculator.res(first, second),
                () -> first + " + " + second + " should equal " + expectedResult);
    }

    //Multiplication test
    @DisplayName("Testing several multiplication test")
    @ParameterizedTest(name = "{0} *  {1} = {2}")
    @CsvSource({
            "0,   1,   0",
            "1,   2,   2",
            "49,  51, 2499",
            "1,  100, 100"
    })
    public void severalMul(Double first, Double second, Double expectedResult) {
        assertEquals(expectedResult, basicCalculator.mult(first, second),
                () -> first + " + " + second + " should equal " + expectedResult);
    }


    //Happy case division
    @DisplayName("Testing several division")
    @ParameterizedTest(name = "{0} / {1} = {2}")
    @CsvSource({
            "0,  1,  0",
            "4,  2,  2",
            "20, 8, 2.5",
            "10,  2, 5"
    })
     void severalDiv(Double first, Double second, Double expectedResult) {
       double result = basicCalculator.div(first, second);
       Assertions.assertEquals(expectedResult, result);
    }

    //Validtion division case
    @DisplayName("Testing several validation division case")
    @ParameterizedTest(name = "{0} /{1}")
    @CsvSource({"4,0"})
    void severalSadDiv(Double first, Double second) {
        var response = assertThrows(RuntimeException.class, ()->{
            Double result = basicCalculator.div(first,second);
        });
        Assertions.assertEquals("No se puede dividir por cero",response.getMessage());
    }
}