package tests;

import domain.Room;
import junit.framework.TestCase;
import org.junit.Test;
import static org.junit.Assert.*;

public class RoomTest extends TestCase {

    public RoomTest() {};

    @Test
    public void testAttributes() {
        Room entry = new Room("Dummy");
        assertEquals("Name should be Dummy", "Dummy", entry.getName());

        entry.setName("Dum Dum");
        assertEquals("Name should be Dum Dum", "Dum Dum", entry.getName());
    }
}