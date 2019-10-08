package repository;

import java.util.ArrayList;

public class Repository<ObjectType> {
  private ArrayList<ObjectType> entries = new ArrayList<ObjectType>();

  public void addEntry(ObjectType newEntry) {
    this.entries.add(newEntry);
  }

  public ArrayList<ObjectType> getAllEntries() {
    return this.entries;
  }

  public ObjectType getByIndex(int index) {
    return this.entries.get(index);
  }

  public void updateByIndex(int index, String name) {
//    this.entries.get(index).setName(name);
  }
}
