package tests;

import junit.framework.TestCase;
import org.junit.jupiter.api.BeforeEach;
import repository.Repository;
import static org.junit.Assert.*;
import org.junit.Test;

import java.util.ArrayList;

class RepositoryTest {

    private Repository<String> stringRepo;

    @BeforeEach
    void setUp() {
        this.stringRepo = new Repository<String>();
        this.stringRepo.addEntry("Entry 0");
        this.stringRepo.addEntry("Entry 1");
        this.stringRepo.addEntry("Entry 2");
    }

    @Test
    void addEntry() {
        this.stringRepo.addEntry("Entry 3");
        assertEquals("Should have entry 3 on 3rd position", this.stringRepo.getByIndex(3), "Entry 3");
    }

    @Test
    void getAllEntries() {
        ArrayList<String> goodList = new ArrayList<String>();
        goodList.add("Entry 0");
        goodList.add("Entry 1");
        goodList.add("Entry 2");
        ArrayList<String> list = this.stringRepo.getAllEntries();

        for (int i=0; i<goodList.size(); i++) {
            assertEquals(goodList.get(i), list.get(i));
        }
    }

    @Test
    void getByIndex() {
        ArrayList<String> goodList = new ArrayList<String>();
        goodList.add("Entry 0");
        goodList.add("Entry 1");
        goodList.add("Entry 2");

        for (int i=0; i<goodList.size(); i++) {
            assertEquals(goodList.get(i), this.stringRepo.getByIndex(i));
        }
    }

    @Test
    void setAtIndex() {
        this.stringRepo.setAtIndex("Dummy", 1);
        assertEquals(this.stringRepo.getByIndex(1), "Dummy");
    }

    @Test
    void deleteIndex() {
        this.stringRepo.deleteIndex(0);
        assertEquals(this.stringRepo.getByIndex(0), "Entry 1");
        assertEquals(this.stringRepo.getByIndex(1), "Entry 2");
    }
}