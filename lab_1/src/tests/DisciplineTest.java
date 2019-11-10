package tests;

import domain.Discipline;
import junit.framework.TestCase;
import org.junit.Test;
import static org.junit.Assert.*;

public class DisciplineTest extends TestCase {

    public DisciplineTest() {};

    @Test
    public void testAttributes() {
        Discipline entry = new Discipline("Dummy");
        assertEquals("Name should be Dummy", "Dummy", entry.getName());

        entry.setName("Dum Dum");
        assertEquals("Name should be Dum Dum", "Dum Dum", entry.getName());
    }
}