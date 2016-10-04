
import static org.junit.Assert.*;
import org.junit.Test;

public class AbbreviatorTests {

    private Abbreviator abbr = new Abbreviator();

    @Test
    public void testInternationalization() {
        assertEquals("i18n", abbr.abbreviate("internationalization"));
        assertEquals("i18n i19X", abbr.abbreviate("internationalization internationalizationX"));
    }

    @Test
    public void testInternationalizationSentence() {
        assertEquals("e6t-r3s are r4y fun!", abbr.abbreviate("elephant-rides are really fun!"));
    }
    
    @Test
    public void testLongSentence() {
        assertEquals(
                "You n2d, n2d not w2t, to c6e t2s c2e-w2s m5n", 
                abbr.abbreviate("You need, need not want, to complete this code-wars mission"));
    }
}
