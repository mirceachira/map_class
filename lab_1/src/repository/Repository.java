package repository;

import java.util.ArrayList;

public class Repository<ObjectType> {
  private ArrayList<ObjectType> entries = new ArrayList<ObjectType>();

  public void addEntry(ObjectType newEntry) {
    this.entries.add(newEntry);
  }
}
