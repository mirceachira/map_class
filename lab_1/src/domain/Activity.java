package domain;

public class Activity {
  public String name;
  public String teacher_name;

  public Activity(String name, String teacher_name) {
    this.name = name;
    this.teacher_name = teacher_name;
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
