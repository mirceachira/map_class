package tests;

import domain.Formation;
import junit.framework.TestCase;
import org.junit.Test;

import static org.junit.Assert.*;

public class FormationTest extends TestCase {

    public FormationTest() {};

    @Test
    public void testAttributes() {
        Formation entry = new Formation("Dummy");
        assertEquals("Name should be Dummy", "Dummy", entry.getName());

        entry.setName("Dum Dum");
        assertEquals("Name should be Dum Dum", "Dum Dum", entry.getName());
    }
}