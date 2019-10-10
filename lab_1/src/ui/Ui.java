package ui;

import controller.Controller;
import domain.Activity;
import domain.Discipline;
import domain.Teacher;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Ui {

  private Controller controller;
  private Scanner reader;

  public Ui() {
    this.controller = new Controller();
    this.reader = new Scanner(System.in);
  }

  private int getNextOption(ArrayList<String> optionList) {
    int minOption = 0;
    int maxOption = optionList.size();
    int choice = -1;

    while (choice < minOption || choice > maxOption) {
      System.out.println("Please pick an option:");

      for (int i = 0; i < optionList.size(); i++) {
        System.out.printf("\t%d - %s\n", i, optionList.get(i));
      }

      choice = this.reader.nextInt();
      if (choice < minOption || choice > maxOption) {
        System.out.println("Invalid choice! Please try again");
      }
    }

    return choice;
  }

  private void addTeacher() {
    this.reader.nextLine(); // Remove remaining newline

    System.out.println("Adding new teacher...");
    System.out.println("\tPlease enter new teacher name:");
    String name = this.reader.nextLine();

    this.controller.addTeacher(name);
    System.out.println("Done adding new teacher!");
  }

  private void addActivity() {
    System.out.println("Adding new activity...");
    this.reader.nextLine(); // Remove remaining newline
    System.out.println("\tPlease enter new activity name:");
    String name = this.reader.nextLine();

    this.reader.nextLine(); // Remove remaining newline
    System.out.println("\tPlease enter new activity teacher_name:");
    String teacher_name = this.reader.nextLine();

    this.controller.addActivity(name, teacher_name);
    System.out.println("Done adding new activity!");
  }

  private void addDiscipline() {
    this.reader.nextLine(); // Remove remaining newline

    System.out.println("Adding new discipline...");
    System.out.println("\tPlease enter new discipline name:");
    String name = this.reader.nextLine();

    this.controller.addDiscipline(name);
    System.out.println("Done adding new discipline!");
  }

  private void create() {
    ArrayList<String> optionList = new ArrayList<>(
        Arrays.asList(
            "go back", "add new teacher", "add new activity", "add new discipline")
    );

    int choice = this.getNextOption(optionList);
    while (choice != 0) {
      switch (choice) {
        // Add choices
        case 1:
          this.addTeacher();
          break;
        case 2:
          this.addActivity();
          break;
        case 3:
          this.addDiscipline();
          break;
      }
      choice = this.getNextOption(optionList);
    }
  }

  private void getAllTeachers() {
    ArrayList<Teacher> teacherList = this.controller.getAllTeachers();

    System.out.print("These are all your teachers");
    for (int i=0; i<teacherList.size(); i++) {
      System.out.printf("\t%d - %s\n", i, teacherList.get(i));
    }
  }

  private void getTeacherByIndex() {
    this.reader.nextLine();

    System.out.println("Enter teacher index: ");
    int index = this.reader.nextInt();

    Teacher entry = this.controller.getTeacherByIndex(index);

    System.out.printf("\t%s", entry);
  }

  private void getTeachers() {
    ArrayList<String> optionList = new ArrayList<>(
        Arrays.asList(
            "go back", "get all teachers", "get teacher by index")
    );

    int choice = this.getNextOption(optionList);
    while (choice != 0) {
      switch (choice) {
        case 1:
          this.getAllTeachers();
          break;
        case 2:
          this.getTeacherByIndex();
          break;
      }
      choice = this.getNextOption(optionList);
    }
  }

  private void getAllActivities() {
    ArrayList<Activity> activityList = this.controller.getAllActivities();

    System.out.print("These are all your activities");
    for (int i=0; i<activityList.size(); i++) {
      System.out.printf("\t%d - %s\n", i, activityList.get(i));
    }
  }

  private void getActivityByIndex() {
    this.reader.nextLine();

    System.out.println("Enter activity index: ");
    int index = this.reader.nextInt();

    Activity entry = this.controller.getActivityByIndex(index);

    System.out.printf("\t%s", entry);
  }

  private void getActivities() {
    ArrayList<String> optionList = new ArrayList<>(
        Arrays.asList(
            "go back", "get all activities", "get activity by index")
    );

    int choice = this.getNextOption(optionList);
    while (choice != 0) {
      switch (choice) {
        case 1:
          this.getAllActivities();
          break;
        case 2:
          this.getActivityByIndex();
          break;
      }
      choice = this.getNextOption(optionList);
    }
  }

  private void getAllDisciplines() {
    ArrayList<Discipline> disciplineList = this.controller.getAllDisciplines();

    System.out.print("These are all your disciplines");
    for (int i=0; i<disciplineList.size(); i++) {
      System.out.printf("\t%d - %s\n", i, disciplineList.get(i));
    }
  }

  private void getDisciplineByIndex() {
    this.reader.nextLine();

    System.out.println("Enter discipline index: ");
    int index = this.reader.nextInt();

    Discipline entry = this.controller.getDisciplineByIndex(index);

    System.out.printf("\t%s", entry);
  }

  private void getDisciplines() {
    ArrayList<String> optionList = new ArrayList<>(
        Arrays.asList(
            "go back", "get all disciplines", "get discipline by index")
    );

    int choice = this.getNextOption(optionList);
    while (choice != 0) {
      switch (choice) {
        case 1:
          this.getAllDisciplines();
          break;
        case 2:
          this.getDisciplineByIndex();
          break;
      }
      choice = this.getNextOption(optionList);
    }
  }

  private void retrieve() {
    ArrayList<String> optionList = new ArrayList<>(
        Arrays.asList(
            "go back", "get teachers", "get activities", "get disciplines")
    );

    int choice = this.getNextOption(optionList);
    while (choice != 0) {
      switch (choice) {
        case 1:
          this.getTeachers();
          break;
        case 2:
          this.getActivities();
          break;
        case 3:
          this.getDisciplines();
          break;
      }
      choice = this.getNextOption(optionList);
    }
  }

  private void updateTeacher() {
    this.reader.nextLine(); // Read to end of line

    System.out.println("Enter teacher index to update: ");
    int index = this.reader.nextInt();

    this.reader.nextLine(); // Read to end of line
    System.out.println("Enter new teacher name");
    String name = this.reader.nextLine();

    this.controller.updateTeacherByIndex(index, name);
    System.out.printf("Updated teacher at %d!", index);
  }

  private void updateActivity() {
    this.reader.nextLine(); // Read to end of line

    System.out.println("Enter activity index to update: ");
    int index = this.reader.nextInt();

    this.reader.nextLine(); // Read to end of line
    System.out.println("Enter new activity name");
    String name = this.reader.nextLine();

    this.controller.updateActivityByIndex(index, name);
    System.out.printf("Updated activity at %d!", index);
  }

  private void updateDiscipline() {
    this.reader.nextLine(); // Read to end of line

    System.out.println("Enter discipline index to update: ");
    int index = this.reader.nextInt();

    this.reader.nextLine(); // Read to end of line
    System.out.println("Enter new discipline name");
    String name = this.reader.nextLine();

    this.controller.updateDisciplineByIndex(index, name);
    System.out.printf("Updated discipline at %d!", index);
  }

  private void update() {
    ArrayList<String> optionList = new ArrayList<>(
        Arrays.asList(
            "go back", "update teacher", "update activity", "update discipline")
    );

    int choice = this.getNextOption(optionList);
    while (choice != 0) {
      switch (choice) {
        case 1:
          this.updateTeacher();
          break;
        case 2:
          this.updateActivity();
          break;
        case 3:
          this.updateDiscipline();
          break;
      }
      choice = this.getNextOption(optionList);
    }
  }

  private void deleteTeacher() {
    this.reader.nextLine(); // Read to end of line

    System.out.println("Enter teacher index to delete: ");
    int index = this.reader.nextInt();

    this.controller.deleteTeacher(index);
  }

  private void deleteActivity() {
    this.reader.nextLine(); // Read to end of line

    System.out.println("Enter activity index to delete: ");
    int index = this.reader.nextInt();

    this.controller.deleteActivity(index);
  }

  private void deleteDiscipline() {
    this.reader.nextLine(); // Read to end of line

    System.out.println("Enter discipline index to delete: ");
    int index = this.reader.nextInt();

    this.controller.deleteDiscipline(index);
  }

  private void delete() {
    ArrayList<String> optionList = new ArrayList<>(
      Arrays.asList(
        "go back", "delete teacher", "delete activity", "delete discipline")
    );

    int choice = this.getNextOption(optionList);
    while (choice != 0) {
      switch (choice) {
        case 1:
          this.deleteTeacher();
          break;
        case 2:
          this.deleteActivity();
          break;
        case 3:
          this.deleteDiscipline();
          break;
      }
      choice = this.getNextOption(optionList);
    }
  }

  public void run() {
    System.out.println("Running the ui!");
    this.controller.addTeacher("Teacher 0");
    this.controller.addTeacher("Teacher 1");
    this.controller.addTeacher("Teacher 2");
    this.controller.addTeacher("Teacher 3");
    this.controller.addTeacher("Teacher 4");

    this.controller.addDiscipline("Discipline 0");
    this.controller.addDiscipline("Discipline 1");
    this.controller.addDiscipline("Discipline 2");
    this.controller.addDiscipline("Discipline 3");
    this.controller.addDiscipline("Discipline 4");

    this.controller.addActivity("Activity 0", "Teacher 1");
    this.controller.addActivity("Activity 1", "Teacher 1");
    this.controller.addActivity("Activity 2", "Teacher 2");
    this.controller.addActivity("Activity 3", "Teacher 2");
    this.controller.addActivity("Activity 4", "Teacher 3");

    System.out.println("Finished my job!");

    ArrayList<String> optionList = new ArrayList<>(
        Arrays.asList(
            "quit the application", "create", "retrieve", "update", "delete")
    );

    int choice = this.getNextOption(optionList);
    while (choice != 0) {
      switch (choice) {
        case 1:
          this.create();
          break;
        case 2:
          this.retrieve();
          break;
        case 3:
          this.update();
          break;
        case 4:
          this.delete();
          break;
      }
      choice = this.getNextOption(optionList);
    }

    System.out.println("Exiting the application! Bye bye!");

  }
}
