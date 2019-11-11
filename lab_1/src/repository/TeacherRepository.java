package repository;

import domain.Teacher;

import java.sql.*;
import java.util.ArrayList;

public class TeacherRepository extends DatabaseRepository {

    public TeacherRepository() {
        super(
            "teacher",
                "(name STRING PRIMARY KEY, rank STRING NOT NULL)"
        );
    }

    private String entryFromObject(Teacher entry) {
        return "\"" + entry.getName() + "\", \"" + entry.getRank() + "\"";
    }

    private Teacher objectFromEntry(ResultSet rs) {
        try {
            return new Teacher(rs.getString("name"), rs.getString("rank"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new Teacher("invalid!!!");
    }

    private void insertEntry(Teacher entry) {
        this.executeSQL("INSERT INTO " + this.tableName + " (name, rank) VALUES (" + this.entryFromObject(entry) + "); ");
    }

    private void updateDatabase(ArrayList<Teacher> list) {
        this.executeSQL( "DELETE FROM " + this.tableName + ";");
        for (int i = 0; i < list.size(); i++) {
            this.insertEntry(list.get(i));
        }
    }

    public void addEntry(Teacher newEntry) {
        ArrayList<Teacher> list = this.getAllEntries();
        list.add(newEntry);
        this.updateDatabase(list);
    }


    public ArrayList<Teacher> getAllEntries() {
        ArrayList<Teacher> entries = new ArrayList<Teacher>();

        try{
            Connection conn = DriverManager.getConnection(this.dbUrl);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM " + tableName + ";");

            while (rs.next()) { entries.add(this.objectFromEntry(rs)); }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return entries;
    }

    public Teacher getByIndex(int index) {
        return this.getAllEntries().get(index);
    }

    public void setAtIndex(Teacher newObject, int index) {
        ArrayList<Teacher> list = this.getAllEntries();
        list.set(index, newObject);
        this.updateDatabase(list);
    }

    public void deleteIndex(int index) {
        ArrayList<Teacher> list = this.getAllEntries();
        list.remove(index);
        this.updateDatabase(list);
    }
}
