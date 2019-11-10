package domain;

import utils.CustomInvalidValueException;

import java.io.Serializable;

public class Teacher extends MyBaseObject implements Serializable {
  private String name;

  public Teacher(String name) {
    super(name);
    this.name = name;
  }

  @Override
  public String getName() {
    return name;
  }

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
