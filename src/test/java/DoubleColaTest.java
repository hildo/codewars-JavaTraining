
import java.time.Instant;
import java.time.temporal.ChronoUnit;

import static org.junit.Assert.*;
import org.junit.Test;

public class DoubleColaTest {

    @Test
    public void test1() {
        String[] names = new String[]{"Sheldon", "Leonard", "Penny", "Rajesh", "Howard"};
        int n = 1;
        assertEquals("Sheldon", new DoubleCola().WhoIsNext(names, n));
    }

    @Test
    public void test2() {
        String[] names = new String[]{"Sheldon", "Leonard", "Penny", "Rajesh", "Howard"};
        int n = 6;
        assertEquals("Sheldon", new DoubleCola().WhoIsNext(names, n));
    }

    @Test
    public void testLong() {
        String[] names = new String[]{"Sheldon", "Leonard", "Penny", "Rajesh", "Howard"};
        int n = 28643950;
        Instant start = Instant.now();
        String name = DoubleCola.WhoIsNext(names, n);
        Instant end = Instant.now();
        assertEquals("Leonard", name);
        assertTrue(start.until(end, ChronoUnit.MILLIS) < 12000);
    }
}
