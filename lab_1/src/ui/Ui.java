package ui;

import controller.Controller;
import domain.*;

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

    this.reader.nextLine(); // Remove remaining newline

    System.out.println("Adding new teacher...");
    System.out.println("\tPlease enter new teacher rank:");
    String rank = this.reader.nextLine();

    this.controller.addTeacher(name, rank);
    System.out.println("Done adding new teacher!");
  }

  private void addActivity() {
    System.out.println("Adding new activity...");
    this.reader.nextLine(); // Remove remaining newline
    System.out.println("\tPlease enter new activity name:");
    String name = this.reader.nextLine();

    this.controller.addActivity(name);
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

  private void addFormation() {
    this.reader.nextLine(); // Remove remaining newline

    System.out.println("Adding new formation...");
    System.out.println("\tPlease enter new formation name:");
    String name = this.reader.nextLine();

    this.controller.addFormation(name);
    System.out.println("Done adding new formation!");
  }

  private void addRoom() {
    this.reader.nextLine(); // Remove remaining newline

    System.out.println("Adding new room...");
    System.out.println("\tPlease enter new room name:");
    String name = this.reader.nextLine();

    this.controller.addRoom(name);
    System.out.println("Done adding new room!");
  }

  private void addTeacherToActivityRelation() {
    this.reader.nextLine(); // Remove remaining newline
    System.out.println("Adding new relation...");
    System.out.println("\tPlease enter new relation keyA:");
    String keyA = this.reader.nextLine();

    this.reader.nextLine(); // Remove remaining newline
    System.out.println("Adding new teacher-activity relation...");
    System.out.println("\tPlease enter new relation keyB:");
    String keyB = this.reader.nextLine();

    this.controller.addTeacherToActivityRelation(keyA, keyB);
    System.out.println("Done adding new teacher-activity relation!");
  }

  private void addFormationToActivityRelation() {
    this.reader.nextLine(); // Remove remaining newline
    System.out.println("Adding new formation-activity relation...");
    System.out.println("\tPlease enter new relation keyA:");
    String keyA = this.reader.nextLine();

    this.reader.nextLine(); // Remove remaining newline
    System.out.println("Adding new relation...");
    System.out.println("\tPlease enter new relation keyB:");
    String keyB = this.reader.nextLine();

    this.controller.addFormationToActivityRelation(keyA, keyB);
    System.out.println("Done adding new formation-activity relation!");
  }

  private void addRoomToActivityRelation() {
    this.reader.nextLine(); // Remove remaining newline
    System.out.println("Adding new room-activity relation...");
    System.out.println("\tPlease enter new relation keyA:");
    String keyA = this.reader.nextLine();

    this.reader.nextLine(); // Remove remaining newline
    System.out.println("Adding new relation...");
    System.out.println("\tPlease enter new relation keyB:");
    String keyB = this.reader.nextLine();

    this.controller.addFormationToActivityRelation(keyA, keyB);
    System.out.println("Done adding new room-activity relation!");
  }

  private void create() {
    ArrayList<String> optionList = new ArrayList<>(
        Arrays.asList(
            "go back", "add new teacher", "add new activity", "add new discipline", "add new formation", "add new room",
                "add new teacher-activity relation",
                "add new formation-activity relation", "add new room-activity relation"
        )
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
        case 4:
          this.addFormation();
          break;
        case 5:
          this.addRoom();
          break;
        case 6:
          this.addTeacherToActivityRelation();
          break;
        case 7:
          this.addFormationToActivityRelation();
          break;
        case 8:
          this.addRoomToActivityRelation();
          break;
      }
      choice = this.getNextOption(optionList);
    }
  }

  private void getAllTeachers() {
    ArrayList<Teacher> teacherList = this.controller.getAllTeachers();

    System.out.print("These are all your teachers\n");
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

    System.out.print("These are all your activities\n");
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

    System.out.print("These are all your disciplines\n");
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

  private void getAllFormations() {
    ArrayList<Formation> formationList = this.controller.getAllFormations();

    System.out.print("These are all your formations\n");
    for (int i=0; i<formationList.size(); i++) {
      System.out.printf("\t%d - %s\n", i, formationList.get(i));
    }
  }

  private void getFormationByIndex() {
    this.reader.nextLine();

    System.out.println("Enter formation index: ");
    int index = this.reader.nextInt();

    Formation entry = this.controller.getFormationByIndex(index);

    System.out.printf("\t%s", entry);
  }

  private void getFormations() {
    ArrayList<String> optionList = new ArrayList<>(
            Arrays.asList("go back", "get all formations", "get formation by index")
    );

    int choice = this.getNextOption(optionList);
    while (choice != 0) {
      switch (choice) {
        case 1:
          this.getAllFormations();
          break;
        case 2:
          this.getFormationByIndex();
          break;
      }
      choice = this.getNextOption(optionList);
    }
  }

  private void getAllRooms() {
    ArrayList<Room> roomList = this.controller.getAllRooms();

    System.out.print("These are all your rooms\n");
    for (int i=0; i<roomList.size(); i++) {
      System.out.printf("\t%d - %s\n", i, roomList.get(i));
    }
  }

  private void getRoomByIndex() {
    this.reader.nextLine();

    System.out.println("Enter room index: ");
    int index = this.reader.nextInt();

    Room entry = this.controller.getRoomByIndex(index);

    System.out.printf("\t%s", entry);
  }

  private void getRooms() {
    ArrayList<String> optionList = new ArrayList<>(
            Arrays.asList("go back", "get all rooms", "get room by index")
    );

    int choice = this.getNextOption(optionList);
    while (choice != 0) {
      switch (choice) {
        case 1:
          this.getAllRooms();
          break;
        case 2:
          this.getRoomByIndex();
          break;
      }
      choice = this.getNextOption(optionList);
    }
  }

  private void getAllTeacherToActivityRelations() {
    ArrayList<Relation> relationList = this.controller.getAllTeacherToActivityRelations();

    System.out.print("These are all your relations\n");
    for (int i=0; i<relationList.size(); i++) {
      System.out.printf("\t%d - %s\n", i, relationList.get(i));
    }
  }

  private void getTeacherToActivityRelationByIndex() {
    this.reader.nextLine();

    System.out.println("Enter relation index: ");
    int index = this.reader.nextInt();

    Relation entry = this.controller.getTeacherToActivityRelationByIndex(index);

    System.out.printf("\t%s", entry);
  }

  private void getTeacherToActivityRelations() {
    ArrayList<String> optionList = new ArrayList<>(
            Arrays.asList(
                    "go back", "get all teacher-activity relations", "get teacher-activity relation by index")
    );

    int choice = this.getNextOption(optionList);
    while (choice != 0) {
      switch (choice) {
        case 1:
          this.getAllTeacherToActivityRelations();
          break;
        case 2:
          this.getTeacherToActivityRelationByIndex();
          break;
      }
      choice = this.getNextOption(optionList);
    }
  }

  private void getAllFormationToActivityRelations() {
    ArrayList<Relation> list = this.controller.getAllFormationToActivityRelations();

    System.out.print("These are all your formation to activity relations\n");
    for (int i=0; i<list.size(); i++) {
      System.out.printf("\t%d - %s\n", i, list.get(i));
    }
  }

  private void getFormationToActivityRelationByIndex() {
    this.reader.nextLine();

    System.out.println("Enter formation to activity relation index: ");
    int index = this.reader.nextInt();

    Relation entry = this.controller.getFormationToActivityRelationByIndex(index);

    System.out.printf("\t%s", entry);
  }

  private void getFormationToActivityRelations() {
    ArrayList<String> optionList = new ArrayList<>(
            Arrays.asList(
                    "go back", "get all formation-activity relations", "get formation-activity relation by index")
    );

    int choice = this.getNextOption(optionList);
    while (choice != 0) {
      switch (choice) {
        case 1:
          this.getAllFormationToActivityRelations();
          break;
        case 2:
          this.getFormationToActivityRelationByIndex();
          break;
      }
      choice = this.getNextOption(optionList);
    }
  }
  private void getAllRoomToActivityRelations() {
    ArrayList<Relation> list = this.controller.getAllRoomToActivityRelations();

    System.out.print("These are all your room to activity relations\n");
    for (int i=0; i<list.size(); i++) {
      System.out.printf("\t%d - %s\n", i, list.get(i));
    }
  }

  private void getRoomToActivityRelationByIndex() {
    this.reader.nextLine();

    System.out.println("Enter room to activity relation index: ");
    int index = this.reader.nextInt();

    Relation entry = this.controller.getRoomToActivityRelationByIndex(index);

    System.out.printf("\t%s", entry);
  }

  private void getRoomToActivityRelations() {
    ArrayList<String> optionList = new ArrayList<>(
            Arrays.asList(
                    "go back", "get all room-activity relations", "get room-activity relation by index")
    );

    int choice = this.getNextOption(optionList);
    while (choice != 0) {
      switch (choice) {
        case 1:
          this.getAllRoomToActivityRelations();
          break;
        case 2:
          this.getRoomToActivityRelationByIndex();
          break;
      }
      choice = this.getNextOption(optionList);
    }
  }

  private void retrieve() {
    ArrayList<String> optionList = new ArrayList<>(
        Arrays.asList(
            "go back", "get teachers", "get activities", "get disciplines", "get formations", "get rooms",
                "get teacher-activity relations", "get formation-activity relations", "get room-activity relations")
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
        case 4:
          this.getFormations();
          break;
        case 5:
          this.getRooms();
          break;
        case 6:
          this.getTeacherToActivityRelations();
          break;
        case 7:
          this.getFormationToActivityRelations();
          break;
        case 8:
          this.getRoomToActivityRelations();
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

  private void updateFormation() {
    this.reader.nextLine(); // Read to end of line

    System.out.println("Enter formation index to update: ");
    int index = this.reader.nextInt();

    this.reader.nextLine(); // Read to end of line
    System.out.println("Enter new formation name");
    String name = this.reader.nextLine();

    this.controller.updateFormationByIndex(index, name);
    System.out.printf("Updated formation at %d!", index);
  }

  private void updateRoom() {
    this.reader.nextLine(); // Read to end of line

    System.out.println("Enter room index to update: ");
    int index = this.reader.nextInt();

    this.reader.nextLine(); // Read to end of line
    System.out.println("Enter new room name");
    String name = this.reader.nextLine();

    this.controller.updateRoomByIndex(index, name);
    System.out.printf("Updated room at %d!", index);
  }

  private void updateTeacherToActivityRelationByIndex() {
    this.reader.nextLine(); // Read to end of line

    System.out.println("Enter teacher-activity relation index to update: ");
    int index = this.reader.nextInt();

    this.reader.nextLine(); // Read to end of line
    System.out.println("Enter new keyA");
    String keyA = this.reader.nextLine();

    this.reader.nextLine(); // Read to end of line
    System.out.println("Enter new keyB");
    String keyB = this.reader.nextLine();

    this.controller.updateTeacherToActivityRelationByIndex(index, keyA, keyB);
    System.out.printf("Updated teacher-activity relation at %d!", index);
  }

  private void updateFormationToActivityRelationByIndex() {
    this.reader.nextLine(); // Read to end of line

    System.out.println("Enter formation-activity relation index to update: ");
    int index = this.reader.nextInt();

    this.reader.nextLine(); // Read to end of line
    System.out.println("Enter new keyA");
    String keyA = this.reader.nextLine();

    this.reader.nextLine(); // Read to end of line
    System.out.println("Enter new keyB");
    String keyB = this.reader.nextLine();

    this.controller.updateFormationToActivityRelationByIndex(index, keyA, keyB);
    System.out.printf("Updated formation-activity relation at %d!", index);
  }

  private void updateRoomToActivityRelationByIndex() {
    this.reader.nextLine(); // Read to end of line

    System.out.println("Enter room-activity relation index to update: ");
    int index = this.reader.nextInt();

    this.reader.nextLine(); // Read to end of line
    System.out.println("Enter new keyA");
    String keyA = this.reader.nextLine();

    this.reader.nextLine(); // Read to end of line
    System.out.println("Enter new keyB");
    String keyB = this.reader.nextLine();

    this.controller.updateRoomToActivityRelationByIndex(index, keyA, keyB);
    System.out.printf("Updated room-activity relation at %d!", index);
  }

  private void update() {
    ArrayList<String> optionList = new ArrayList<>(
        Arrays.asList(
            "go back", "update teacher", "update activity", "update discipline", "update formation", "update room",
                "update teacher-activity relation", "update formation-activity relation",
                "update room-activity relation"
        )
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
        case 4:
          this.updateFormation();
          break;
        case 5:
          this.updateRoom();
          break;
        case 6:
          this.updateTeacherToActivityRelationByIndex();
          break;
        case 7:
          this.updateFormationToActivityRelationByIndex();
          break;
        case 8:
          this.updateRoomToActivityRelationByIndex();
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

  private void deleteFormation() {
    this.reader.nextLine(); // Read to end of line

    System.out.println("Enter formation index to delete: ");
    int index = this.reader.nextInt();

    this.controller.deleteFormation(index);
  }

  private void deleteRoom() {
    this.reader.nextLine(); // Read to end of line

    System.out.println("Enter room index to delete: ");
    int index = this.reader.nextInt();

    this.controller.deleteRoom(index);
  }

  private void deleteTeacherToActivityRelation() {
    this.reader.nextLine(); // Read to end of line

    System.out.println("Enter teacher-activity relation index to delete: ");
    int index = this.reader.nextInt();

    this.controller.deleteTeacherToActivityRelation(index);
  }

  private void deleteFormationToActivityRelation() {
    this.reader.nextLine(); // Read to end of line

    System.out.println("Enter formation-activity relation index to delete: ");
    int index = this.reader.nextInt();

    this.controller.deleteFormationToActivityRelation(index);
  }

  private void deleteRoomToActivityRelation() {
    this.reader.nextLine(); // Read to end of line

    System.out.println("Enter room-activity relation index to delete: ");
    int index = this.reader.nextInt();

    this.controller.deleteRoomToActivityRelation(index);
  }

  private void delete() {
    ArrayList<String> optionList = new ArrayList<>(
      Arrays.asList(
        "go back", "delete teacher", "delete activity", "delete discipline", "delete formation", "delete room",
              "delete teacher-activity relation", "delete formation-activity relation",
              "delete room-activity relation"
      )
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
        case 4:
          this.deleteFormation();
          break;
        case 5:
          this.deleteRoom();
          break;
        case 6:
          this.deleteTeacherToActivityRelation();
          break;
        case 7:
          this.deleteFormationToActivityRelation();
          break;
        case 8:
          this.deleteRoomToActivityRelation();
          break;
      }
      choice = this.getNextOption(optionList);
    }
  }

  private void teachersByRank() {
    this.reader.nextLine(); // Read to end of line

    System.out.println("Enter teacher rank (professor / lecturer / dean): ");
    String rank = this.reader.nextLine();

    ArrayList<Teacher> teacherList = this.controller.getSortedTeachersByRank(rank);

    System.out.print("These are all your teachers for rank " + rank + "\n");
    for (int i=0; i<teacherList.size(); i++) {
      System.out.printf("\t%d - %s\n", i, teacherList.get(i));
    }

  }

  private void activitiesByRoom() {

  }

  private void formationTimetable() {

  }

  private void reports() {
    ArrayList<String> optionList = new ArrayList<>(
            Arrays.asList(
                    "go back", "sorted teachers by rank", "sorted activities in a room", "formation timetable"
            )
    );

    int choice = this.getNextOption(optionList);
    while (choice != 0) {
      switch (choice) {
        case 1:
          this.teachersByRank();
          break;
        case 2:
          this.activitiesByRoom();
          break;
        case 3:
          this.formationTimetable();
          break;
      }
      choice = this.getNextOption(optionList);
    }
  }


  public void run() {
    System.out.println("Running the ui!");

    while (this.controller.getAllFormations().size() > 0) {
      this.controller.deleteFormation(this.controller.getAllFormations().size() - 1);
    }

    // Adding from file
//    this.controller.readTeacherFile();
//    this.controller.readActivityFile();
//    this.controller.readDisciplineFile();
//    this.controller.readFormationFile();
//    this.controller.readRoomFile();

    // Adding in memory
        this.controller.addTeacher("Teacher 0", "lecturer");
        this.controller.addTeacher("Teacher 1", "lecturer");
        this.controller.addTeacher("Teacher 2", "professor");
        this.controller.addTeacher("Teacher 3", "professor");
        this.controller.addTeacher("Teacher 4", "dean");

        this.controller.addDiscipline("Discipline 0");
        this.controller.addDiscipline("Discipline 1");
        this.controller.addDiscipline("Discipline 2");
        this.controller.addDiscipline("Discipline 3");
        this.controller.addDiscipline("Discipline 4");

        this.controller.addActivity("Activity 0");
        this.controller.addActivity("Activity 1");
        this.controller.addActivity("Activity 2");
        this.controller.addActivity("Activity 3");
        this.controller.addActivity("Activity 4");

        this.controller.addFormation("Formation 0");
        this.controller.addFormation("Formation 1");
        this.controller.addFormation("Formation 2");
        this.controller.addFormation("Formation 3");
        this.controller.addFormation("Formation 4");

        this.controller.addRoom("Room 0");
        this.controller.addRoom("Room 1");
        this.controller.addRoom("Room 2");
        this.controller.addRoom("Room 3");
        this.controller.addRoom("Room 4");

    // TODO: Support reading these from file as well

        this.controller.addTeacherToActivityRelation("Activity 0", "Teacher 1");
        this.controller.addTeacherToActivityRelation("Activity 1", "Teacher 1");
        this.controller.addTeacherToActivityRelation("Activity 2", "Teacher 2");
        this.controller.addTeacherToActivityRelation("Activity 3", "Teacher 2");
        this.controller.addTeacherToActivityRelation("Activity 4", "Teacher 3");

        this.controller.addFormationToActivityRelation("Activity 0", "Formation 1");
        this.controller.addFormationToActivityRelation("Activity 1", "Formation 1");
        this.controller.addFormationToActivityRelation("Activity 2", "Formation 2");
        this.controller.addFormationToActivityRelation("Activity 3", "Formation 2");
        this.controller.addFormationToActivityRelation("Activity 4", "Formation 3");

        this.controller.addRoomToActivityRelation("Activity 0", "Room 1");
        this.controller.addRoomToActivityRelation("Activity 1", "Room 1");
        this.controller.addRoomToActivityRelation("Activity 2", "Room 2");
        this.controller.addRoomToActivityRelation("Activity 3", "Room 2");
        this.controller.addRoomToActivityRelation("Activity 4", "Room 3");

    System.out.println("Finished my job!");

    ArrayList<String> optionList = new ArrayList<>(
        Arrays.asList(
            "quit the application", "create", "retrieve", "update", "delete", "reports")
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
        case 5:
          this.reports();
          break;
      }
      choice = this.getNextOption(optionList);
    }

    System.out.println("Exiting the application! Bye bye!");

  }
}
