package tests;

import domain.Teacher;
import junit.framework.TestCase;
import org.junit.Test;
import static org.junit.Assert.*;

public class TeacherTest extends TestCase {

    public TeacherTest() {};

    @Test
    public void testAttributes() {
        Teacher entry = new Teacher("Dummy");
        assertEquals("Name should be Dummy", "Dummy", entry.getName());

        entry.setName("Dum Dum");
        assertEquals("Name should be Dum Dum", "Dum Dum", entry.getName());
    }
}