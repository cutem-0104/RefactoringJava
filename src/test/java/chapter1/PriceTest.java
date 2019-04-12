package chapter1;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class PriceTest {

    @Test
    public void testGetCharge1() {
        Price price = new ChildrensPrice();
        assertEquals(Movie.CHILDRENS, price.getPriceCode());

        boolean result = 1.5 == price.getCharge(2);
        assertTrue(result);
    }

    @Test
    public void testGetCharge2() {
        Price price = new ChildrensPrice();
        assertEquals(Movie.CHILDRENS, price.getPriceCode());

        boolean result = 1.5 == price.getCharge(3);
        assertTrue(result);
    }

    @Test
    public void testGetCharge3() {
        Price price = new ChildrensPrice();
        assertEquals(Movie.CHILDRENS, price.getPriceCode());

        boolean result = 3.0 == price.getCharge(4);
        assertTrue(result);
    }

    @Test
    public void testGetCharge4() {
        Price price = new ChildrensPrice();
        assertEquals(Movie.CHILDRENS, price.getPriceCode());

        boolean result = 1.5 == price.getCharge(0);
        assertTrue(result);
    }
}
