package repository;

import domain.Room;

import java.sql.*;
import java.util.ArrayList;

public class RoomRepository  extends DatabaseRepository {

    public RoomRepository() {
        super(
                "room",
                "(name STRING PRIMARY KEY)"
        );
    }

    String entryFromObject(Room entry) {
        return "\"" + entry.getName() + "\"";
    }

    Room objectFromEntry(ResultSet rs) {
        try {
            return new Room(rs.getString("name"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new Room("invalid!!!");
    }

    private void insertEntry(Room entry) {
        this.executeSQL("INSERT INTO " + this.tableName + " (name) VALUES (" + this.entryFromObject(entry) + "); ");
    }

    private void updateDatabase(ArrayList<Room> list) {
        this.executeSQL( "DELETE FROM " + this.tableName + ";");
        for (int i = 0; i < list.size(); i++) {
            this.insertEntry(list.get(i));
        }
    }

    public void addEntry(Room newEntry) {
        ArrayList<Room> list = this.getAllEntries();
        list.add(newEntry);
        this.updateDatabase(list);
    }


    public ArrayList<Room> getAllEntries() {
        ArrayList<Room> entries = new ArrayList<Room>();

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

    public Room getByIndex(int index) {
        return this.getAllEntries().get(index);
    }

    public void setAtIndex(Room newObject, int index) {
        ArrayList<Room> list = this.getAllEntries();
        list.set(index, newObject);
        this.updateDatabase(list);
    }

    public void deleteIndex(int index) {
        ArrayList<Room> list = this.getAllEntries();
        list.remove(index);
        this.updateDatabase(list);
    }
}
