package domain;

import utils.CustomInvalidValueException;

import java.io.Serializable;

public class Teacher extends MyBaseObject implements Serializable {
  private String name;
  private String rank;

  public Teacher(String line) {
    super(line);
    String[] lineData = line.split(",");

    this.name = lineData[0];
    this.rank = lineData[1];
  }

  public Teacher(String name, String rank) {
    super(name);
    this.name = name;
    this.rank = rank;
  }

  @Override
  public String getName() {
    return name;
  }

  public String getRank() { return rank; }

  public void validateName(String name) throws  CustomInvalidValueException {
    if (name.length() <= 1) {
      throw new CustomInvalidValueException();
    }
  }
  public boolean setName(String name) {
    try {
      this.validateName(name);
      this.name = name;
    } catch (CustomInvalidValueException e) {
      return false;
    }

    return true;
  }

  @Override
  public String toString() {
    return name;
  }

}
