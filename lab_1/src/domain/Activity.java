package domain;

public class Activity {
  public String name;

  public Activity(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "Activity{" +
        "name='" + name + '\'' +
        '}';
  }
}
