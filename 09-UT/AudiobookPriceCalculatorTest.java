package put.io.testing.audiobooks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AudiobookPriceCalculatorTest {
    private AudiobookPriceCalculator calculator;
    private Audiobook audiobook;

    @BeforeEach
    void setUp(){
        this.calculator = new AudiobookPriceCalculator();
        this.audiobook = new Audiobook("Wieśmak", 100.0);
    }

    @Test
    void testIsSubscriber() {
        Customer customer = new Customer("Andrzej", Customer.LoyaltyLevel.GOLD, true);
        double result = this.calculator.calculate(customer, this.audiobook);
        assertEquals(result, 0.0);
    }

    @Test
    void testIsSilver(){
        Customer customer = new Customer("Budda", Customer.LoyaltyLevel.SILVER, false);
        double result = this.calculator.calculate(customer, this.audiobook);
        assertEquals(result, 90.00);
    }

    @Test
    void testIsGold(){
        Customer customer = new Customer("Dima", Customer.LoyaltyLevel.GOLD, false);
        double result = this.calculator.calculate(customer, this.audiobook);
        assertEquals(result, 80.00);
    }

    @Test
    void testIsNobody(){
        Customer customer = new Customer("Eryczek", Customer.LoyaltyLevel.STANDARD, false);
        double result = this.calculator.calculate(customer, this.audiobook);
        assertEquals(result, 100.00);
    }
}