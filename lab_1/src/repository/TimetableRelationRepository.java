package repository;

import domain.Relation;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class TimetableRelationRepository extends DatabaseRepository {

  public TimetableRelationRepository() {
    super(
        "timetablerelation",
        "(activityName STRING, roomName STRING, teacherName STRING, formationName STRING, dateString STRING)"
    );
  }

  String entryFromObject(Relation entry) {
    return
        "\"" + entry.getActivityName() + "\"," +
        "\"" + entry.getRoomName() + "\"," +
        "\"" + entry.getTeacherName() + "\"," +
        "\"" + entry.getFormationName() + "\"," +
        "\"" + entry.getDateString() + "\"";
  }

  Relation objectFromEntry(ResultSet rs) {
    try {
      return new Relation(
          rs.getString("activityName"),
          rs.getString("roomName"),
          rs.getString("teacherName"),
          rs.getString("formationName"),
          rs.getString("dateString")
      );
    } catch (Exception e) {
      e.printStackTrace();
    }

    // TODO: try catch this somewhere
    return new Relation("invalid!!!", "invalid!!!","invalid!!!","invalid!!!","invalid!!!");
  }

  private void insertEntry(Relation entry) {
    this.executeSQL(
        "INSERT INTO " + this.tableName + " (activityName, roomName, teacherName, formationName, dateString) VALUES (" + this.entryFromObject(entry) + "); ");
  }

  private void updateDatabase(ArrayList<Relation> list) {
    this.executeSQL( "DELETE FROM " + this.tableName + ";");
    for (Relation relation : list) {
      this.insertEntry(relation);
    }
  }

  public void addEntry(Relation newEntry) throws Exception {
    ArrayList<Relation> list = this.getAllEntries();

    // activity - room - teacher - formation - hour
    for (Relation r: list) {
      if (r.activityName.equals(newEntry.activityName)) {
        if (r.teacherName.equals(newEntry.teacherName) && r.dateString.equals(newEntry.dateString)) {
          throw new Exception("at most one activity can take place in a room at a certain time");
        }
      }

      if (r.teacherName.equals(newEntry.teacherName)) {
        if (r.dateString.equals(newEntry.dateString)) {
          throw new Exception("teacher cannot have 2 different activities at the same time");
        }
      }

      if (r.formationName.equals(newEntry.formationName)) {
        if (r.dateString.equals(newEntry.dateString)) {
          throw new Exception("a formation cannot have 2 different activities at the same time");
        }
      }

      if (r.formationName.equals(newEntry.formationName)) {
        if (r.activityName.equals(newEntry.activityName)) {
          throw new Exception("a formation should not have the same activity more than once");
        }
      }
    }

    list.add(newEntry);
    this.updateDatabase(list);
  }

  public ArrayList<Relation> getAllEntries() {
    ArrayList<Relation> entries = new ArrayList<Relation>();

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

  public Relation getByIndex(int index) {
    return this.getAllEntries().get(index);
  }

  public void setAtIndex(Relation newObject, int index) {
    ArrayList<Relation> list = this.getAllEntries();
    list.set(index, newObject);
    this.updateDatabase(list);
  }

  public void deleteIndex(int index) {
    ArrayList<Relation> list = this.getAllEntries();
    list.remove(index);
    this.updateDatabase(list);
  }
}
