package repository;

import domain.Activity;
import domain.Room;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ActivityRepository extends DatabaseRepository {
  public ActivityRepository() {
    super(
        "activity",
        "(name STRING PRIMARY KEY)"
    );
  }

  String entryFromObject(Activity entry) {
    return "\"" + entry.getName() + "\"";
  }

  Activity objectFromEntry(ResultSet rs) {
    try {
      return new Activity(rs.getString("name"));
    } catch (Exception e) {
      e.printStackTrace();
    }

    return new Activity("invalid!!!");
  }

  private void insertEntry(Activity entry) {
    this.executeSQL("INSERT INTO " + this.tableName + " (name) VALUES (" + this.entryFromObject(entry) + "); ");
  }

  private void updateDatabase(ArrayList<Activity> list) {
    this.executeSQL( "DELETE FROM " + this.tableName + ";");
    for (int i = 0; i < list.size(); i++) {
      this.insertEntry(list.get(i));
    }
  }

  public void addEntry(Activity newEntry) {
    ArrayList<Activity> list = this.getAllEntries();
    list.add(newEntry);
    this.updateDatabase(list);
  }

  public ArrayList<Activity> getAllEntries() {
    ArrayList<Activity> entries = new ArrayList<Activity>();

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

  public Activity getByIndex(int index) {
    return this.getAllEntries().get(index);
  }

  public void setAtIndex(Activity newObject, int index) {
    ArrayList<Activity> list = this.getAllEntries();
    list.set(index, newObject);
    this.updateDatabase(list);
  }

  public void deleteIndex(int index) {
    ArrayList<Activity> list = this.getAllEntries();
    list.remove(index);
    this.updateDatabase(list);
  }
}
