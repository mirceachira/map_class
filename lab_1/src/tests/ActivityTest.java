package tests;

import domain.Activity;
import junit.framework.TestCase;
import org.junit.Test;
import static org.junit.Assert.*;

public class ActivityTest extends TestCase {

    public ActivityTest() {};

    @Test
    public void testAttributes() {
        Activity entry = new Activity("Dummy");
        assertEquals("Name should be Dummy", "Dummy", entry.getName());

        entry.setName("Dum Dum");
        assertEquals("Name should be Dum Dum", "Dum Dum", entry.getName());
    }
}