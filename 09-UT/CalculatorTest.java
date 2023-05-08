package put.io.testing.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    void setUp(){
        this.calculator = new Calculator();
    }

    @Test
    void testAdd() {
        //Calculator calculator = new Calculator();
        int a = 5;
        int b = 7;
        int result = this.calculator.add(a, b);
        assertEquals(result, 12);

        int c = 13;
        int d = 20;
        int result2 = this.calculator.add(c, d);
        assertEquals(result2, 33);
    }

    @Test
    void testMultiply() {
        //Calculator calculator = new Calculator();
        int a = 5;
        int b = 7;
        int result = this.calculator.multiply(a, b);
        assertEquals(result, 35);

        int c = 13;
        int d = 20;
        int result2 = this.calculator.multiply(c, d);
        assertEquals(result2, 260);
    }

    @Test
    void testAddPositiveNumbers() {
        //Calculator calculator = new Calculator();
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, ()->{
            int x = -5;
            int y = 7;
            int result = this.calculator.addPositiveNumbers(x, y);
        }, "Illegal Argument Exception expected");

        assertEquals(this.calculator.addPositiveNumbers(1, 2), 3);
    }
}