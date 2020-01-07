package repository;

import domain.Formation;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class FormationRepository  extends DatabaseRepository {

  public FormationRepository() {
    super(
        "formation",
        "(name STRING PRIMARY KEY)"
    );
  }

  String entryFromObject(Formation entry) {
    return "\"" + entry.getName() + "\"";
  }

  Formation objectFromEntry(ResultSet rs) {
    try {
      return new Formation(rs.getString("name"));
    } catch (Exception e) {
      e.printStackTrace();
    }

    return new Formation("invalid!!!");
  }

  private void insertEntry(Formation entry) {
    this.executeSQL("INSERT INTO " + this.tableName + " (name) VALUES (" + this.entryFromObject(entry) + "); ");
  }

  private void updateDatabase(ArrayList<Formation> list) {
    this.executeSQL( "DELETE FROM " + this.tableName + ";");
    for (int i = 0; i < list.size(); i++) {
      this.insertEntry(list.get(i));
    }
  }

  public void addEntry(Formation newEntry) {
    ArrayList<Formation> list = this.getAllEntries();
    list.add(newEntry);
    this.updateDatabase(list);
  }


  public ArrayList<Formation> getAllEntries() {
    ArrayList<Formation> entries = new ArrayList<Formation>();

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

  public Formation getByIndex(int index) {
    return this.getAllEntries().get(index);
  }

  public void setAtIndex(Formation newObject, int index) {
    ArrayList<Formation> list = this.getAllEntries();
    list.set(index, newObject);
    this.updateDatabase(list);
  }

  public void deleteIndex(int index) {
    ArrayList<Formation> list = this.getAllEntries();
    list.remove(index);
    this.updateDatabase(list);
  }
}
