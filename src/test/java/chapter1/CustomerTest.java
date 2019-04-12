package chapter1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerTest {

    Movie movie1 = new Movie("mv1", Movie.REGULAR);
    Movie movie2 = new Movie("mv2", Movie.CHILDRENS);
    Movie movie3 = new Movie("mv3", Movie.NEW_RELEASE);

    @Test
    public void testStatement1() {
        Customer customer = new Customer("rent1");
        customer.addRental(new Rental(movie1, 10));
        customer.addRental(new Rental(movie2, 2));
        customer.addRental(new Rental(movie3, 3));
        customer.addRental(new Rental(movie3, 1));

        String result = "Rental record for rent1\n" +
                "\tmv1\t14.0\n" +
                "\tmv2\t1.5\n" +
                "\tmv3\t9.0\n" +
                "\tmv3\t3.0\n" +
                "Amount owed is 27.5\n" +
                "You earned 5 frequent renter points";
        assertEquals(result, customer.statement());
    }

    @Test
    public void testStatement2() {
        Customer customer = new Customer("rent2");
        customer.addRental(new Rental(movie1, 10));
        customer.addRental(new Rental(movie2, 2));
        customer.addRental(new Rental(movie3, 1));

        String result = "Rental record for rent2\n" +
                "\tmv1\t14.0\n" +
                "\tmv2\t1.5\n" +
                "\tmv3\t3.0\n" +
                "Amount owed is 18.5\n" +
                "You earned 3 frequent renter points";
        assertEquals(result, customer.statement());
    }

    @Test
    public void testStatement3() {
        Customer customer = new Customer("rent1");
        customer.addRental(new Rental(movie1, 10));
        customer.addRental(new Rental(movie2, 2));
        customer.addRental(new Rental(movie3, 3));
        customer.addRental(new Rental(movie3, 1));

        String result = "<H1>Rentals for <EM>rent1</EM></H1><P>\n" +
                "mv1: 14.0<BR>\n" +
                "mv2: 1.5<BR>\n" +
                "mv3: 9.0<BR>\n" +
                "mv3: 3.0<BR>\n" +
                "<P>You owe <EM>27.5</EM><P>\n" +
                "On this rental you earned <EM>5</EM> frequent renter points<P>";
        assertEquals(result, customer.htmlStatement());
    }

    @Test
    public void testStatement4() {
        Customer customer = new Customer("rent2");
        customer.addRental(new Rental(movie1, 10));
        customer.addRental(new Rental(movie2, 2));
        customer.addRental(new Rental(movie3, 1));

        String result = "<H1>Rentals for <EM>rent2</EM></H1><P>\n" +
                "mv1: 14.0<BR>\n" +
                "mv2: 1.5<BR>\n" +
                "mv3: 3.0<BR>\n" +
                "<P>You owe <EM>18.5</EM><P>\n" +
                "On this rental you earned <EM>3</EM> frequent renter points<P>";
        assertEquals(result, customer.htmlStatement());
    }
}
