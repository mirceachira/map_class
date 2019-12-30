package tests;

import controller.Controller;
import domain.Teacher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

class ControllerTest {

    private Controller controller;

    @BeforeEach
    void setUp() {
        this.controller = new Controller();
        this.controller.addTeacher("Entry 0");
        this.controller.addTeacher("Entry 1");
        this.controller.addTeacher("Entry 2");
    }

    @Test
    void addTeacher() {
        this.controller.addTeacher("Entry 3");
        assertEquals("Should have entry 3 on 3rd position", this.controller.getTeacherByIndex(3), "Entry 3");
    }

    @Test
    void getAllTeachers() {
        ArrayList<String> goodList = new ArrayList<String>();
        goodList.add("Entry 0");
        goodList.add("Entry 1");
        goodList.add("Entry 2");
        ArrayList<Teacher> list = this.controller.getAllTeachers();

        for (int i=0; i<goodList.size(); i++) {
            assertEquals(goodList.get(i), list.get(i).getName());
        }
    }

    @Test
    void getTeacherByIndex() {
        ArrayList<String> goodList = new ArrayList<String>();
        goodList.add("Entry 0");
        goodList.add("Entry 1");
        goodList.add("Entry 2");

        for (int i=0; i<goodList.size(); i++) {
            assertEquals(goodList.get(i), this.controller.getTeacherByIndex(i).getName());
        }
    }

    @Test
    void updateTeacherByIndex() {
        this.controller.updateTeacherByIndex(1, "Dummy");
        assertEquals(this.controller.getTeacherByIndex(1).getName(), "Dummy");
    }

    @Test
    void deleteTeacher() {
        this.controller.deleteTeacher(0);
        assertEquals(this.controller.getTeacherByIndex(0).getName(), "Entry 1");
        assertEquals(this.controller.getTeacherByIndex(1).getName(), "Entry 2");
    }
}
