package chapter6;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Vector;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MethodExtractionTest {
    private MethodExtraction methodExtraction;

    @Before
    public void initialize() {
        methodExtraction = new MethodExtraction();
        Vector<Order> orders = methodExtraction.getOrders();
        orders.add(new Order(1.0));
        orders.add(new Order(2.0));
        orders.add(new Order(3.0));
    }

    @Test
    public void testPrintBanner() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        //テスト対象メソッド呼び出し
        methodExtraction.printBanner();

        //printlnの改行部分はlineSeparatorを付ける
        String result =
                "*******************" + System.lineSeparator() +
                "***Customer Owes***" + System.lineSeparator() +
                "*******************" + System.lineSeparator();

        assertThat(out.toString(), is(result));
    }

    @Test
    public void testPrintDetails() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        methodExtraction.printDetails(1.0);

        //printlnの改行部分はlineSeparatorを付ける
        String result =
                "name: name" + System.lineSeparator() +
                "amount: 1.0" + System.lineSeparator();

        assertThat(out.toString(), is(result));
    }

    @Test
    public void testGetOutstanding() {
        double outstanding = methodExtraction.getOutstanding();
        assertThat(6.0, is(outstanding));
    }

    @Test
    public void testGetOutstanding1() {
        MethodExtraction methodExtraction = new MethodExtraction();
        double outstanding = methodExtraction.getOutstanding();
        assertThat(0.0, is(outstanding));
    }

    @Test
    public void testGetOutstanding2() {
        double outstanding = methodExtraction.getOutstanding(1.2);
        assertThat(7.2, is(outstanding));
    }

    @Test
    public void testGetOutstanding3() {
        MethodExtraction methodExtraction = new MethodExtraction();
        double outstanding = methodExtraction.getOutstanding(1.2);
        assertThat(1.2, is(outstanding));
    }
}
