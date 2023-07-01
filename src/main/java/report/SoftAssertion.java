package report;

import java.io.IOException;
import java.util.List;

public class SoftAssertion extends AbstractAssertion{
    public static void assertTrue(final boolean condition, final String description) throws IOException {
        assertTrue(condition, description,false);
    }


    public static void assertFalse(final boolean condition, final String description) throws IOException {
        assertFalse(condition, description, false);
    }



    public static void assertEquals(final String actual, final String expected, final String description){
        assertEquals(actual, expected, description, false);
    }

    public static void assertEquals(final float actual, final float expected, final String description){
        assertEquals(actual, expected, description, false);
    }

    public static void assertEquals(final int actual, final int expected, final String description){
        assertEquals(actual, expected, description, false);
    }

    public static void assertContains(final String actual, final String expected, final String description){
        assertContains(actual, expected, description, false);
    }

    public static void assertEquals(final List<String> actual, final List<String> expected, final String description){
        assertEquals(actual, expected, description, false);
    }
}
