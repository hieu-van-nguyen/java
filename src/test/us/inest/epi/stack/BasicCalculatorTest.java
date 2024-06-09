package us.inest.epi.stack;

import org.junit.Test;
import us.inest.epi.array.SpiralOrder;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BasicCalculatorTest {
    @Test
    public void testSpiralOrder() {
        String exp = "31 + 17";
        int result = BasicCalculator.calculate(exp);
        assertThat(result, is(48));
    }
}
