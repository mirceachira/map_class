package repository;

import domain.Discipline;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DisciplineRepository extends DatabaseRepository {

  public DisciplineRepository() {
    super(
        "discipline",
        "(name STRING PRIMARY KEY)"
    );
  }

  String entryFromObject(Discipline entry) {
    return "\"" + entry.getName() + "\"";
  }

  Discipline objectFromEntry(ResultSet rs) {
    try {
      return new Discipline(rs.getString("name"));
    } catch (Exception e) {
      e.printStackTrace();
    }

    return new Discipline("invalid!!!");
  }

  private void insertEntry(Discipline entry) {
    this.executeSQL("INSERT INTO " + this.tableName + " (name) VALUES (" + this.entryFromObject(entry) + "); ");
  }

  private void updateDatabase(ArrayList<Discipline> list) {
    this.executeSQL( "DELETE FROM " + this.tableName + ";");
    for (int i = 0; i < list.size(); i++) {
      this.insertEntry(list.get(i));
    }
  }

  public void addEntry(Discipline newEntry) {
    ArrayList<Discipline> list = this.getAllEntries();
    list.add(newEntry);
    this.updateDatabase(list);
  }


  public ArrayList<Discipline> getAllEntries() {
    ArrayList<Discipline> entries = new ArrayList<Discipline>();

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

  public Discipline getByIndex(int index) {
    return this.getAllEntries().get(index);
  }

  public void setAtIndex(Discipline newObject, int index) {
    ArrayList<Discipline> list = this.getAllEntries();
    list.set(index, newObject);
    this.updateDatabase(list);
  }

  public void deleteIndex(int index) {
    ArrayList<Discipline> list = this.getAllEntries();
    list.remove(index);
    this.updateDatabase(list);
  }
}
