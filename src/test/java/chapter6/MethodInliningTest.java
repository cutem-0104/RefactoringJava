package chapter6;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MethodInliningTest {
    MethodInlining methodInlining;

    @Before
    public void initialize() {
        methodInlining = new MethodInlining();
    }

    @Test
    public void testGetRating() {
        methodInlining._numberOfLateDeliveries = 1;
        assertThat(methodInlining.getRating(), is(1));
    }
}
