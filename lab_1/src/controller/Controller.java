package controller;

import domain.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import repository.FileRepository;
import repository.Repository;
import repository.RoomRepository;
import repository.TeacherRepository;


public class Controller {
  // Database repository
  private TeacherRepository teacherRepo;
  private RoomRepository roomRepo;

  // File repository
  private FileRepository<Activity> activityRepo;
  private FileRepository<Discipline> disciplineRepo;
  private FileRepository<Formation> formationRepo;

  // In memory repository
  private Repository<Relation> teacherToActivityRelationRepo;
  private Repository<Relation> formationToActivityRelationRepo;
  private Repository<Relation> roomToActivityRelationRepo;

  public Controller() {
    this.teacherRepo = new TeacherRepository();
    this.roomRepo = new RoomRepository();

    this.activityRepo = new FileRepository<Activity>(Activity.class, "activity.csv");
    this.disciplineRepo = new FileRepository<Discipline>(Discipline.class,"discipline.csv");
    this.formationRepo = new FileRepository<Formation>(Formation.class, "formation.csv");

    this.teacherToActivityRelationRepo = new Repository<Relation>();
    this.formationToActivityRelationRepo = new Repository<Relation>();
    this.roomToActivityRelationRepo = new Repository<Relation>();
  }

  public void addTeacher(String name) {
    Teacher newTeacher = new Teacher(name);
    this.teacherRepo.addEntry(newTeacher);
  }

  public void addTeacher(String name, String rank) {
    Teacher newTeacher = new Teacher(name, rank);
    this.teacherRepo.addEntry(newTeacher);
  }

  public void addActivity(String name) {
    Activity newActivity = new Activity(name);
    this.activityRepo.addEntry(newActivity);
  }

  public void addDiscipline(String name) {
    Discipline newDiscipline = new Discipline(name);
    this.disciplineRepo.addEntry(newDiscipline);
  }

  public void addRoom(String name) {
    Room newRoom = new Room(name);
    this.roomRepo.addEntry(newRoom);
  }

  public void addFormation(String name) {
    Formation newFormation = new Formation(name);
    this.formationRepo.addEntry(newFormation);
  }

  public void addTeacherToActivityRelation(String keyA, String keyB) {
    Relation newRelation = new Relation(keyA, keyB);
    this.teacherToActivityRelationRepo.addEntry(newRelation);
  }

  public void addFormationToActivityRelation(String keyA, String keyB) {
    Relation newRelation = new Relation(keyA, keyB);
    this.formationToActivityRelationRepo.addEntry(newRelation);
  }

  public void addRoomToActivityRelation(String keyA, String keyB, String keyC) {
    Relation newRelation = new Relation(keyA, keyB, keyC);
    this.roomToActivityRelationRepo.addEntry(newRelation);
  }

  public ArrayList<Teacher> getAllTeachers() { return this.teacherRepo.getAllEntries(); }

  public ArrayList<Activity> getAllActivities() {
    return this.activityRepo.getAllEntries();
  }

  public ArrayList<Discipline> getAllDisciplines() {
    return this.disciplineRepo.getAllEntries();
  }

  public ArrayList<Room> getAllRooms() {
    return this.roomRepo.getAllEntries();
  }

  public ArrayList<Formation> getAllFormations() {
    return this.formationRepo.getAllEntries();
  }

  public ArrayList<Relation> getAllTeacherToActivityRelations() {
    return this.teacherToActivityRelationRepo.getAllEntries();
  }

  public ArrayList<Relation> getAllFormationToActivityRelations() {
    return this.formationToActivityRelationRepo.getAllEntries();
  }

  public ArrayList<Relation> getAllRoomToActivityRelations() {
    return this.roomToActivityRelationRepo.getAllEntries();
  }

  public Teacher getTeacherByIndex(int index) {
    return this.teacherRepo.getByIndex(index);
  }

  public Activity getActivityByIndex(int index) {
    return this.activityRepo.getByIndex(index);
  }

  public Discipline getDisciplineByIndex(int index) {
    return this.disciplineRepo.getByIndex(index);
  }

  public Room getRoomByIndex(int index) {
    return this.roomRepo.getByIndex(index);
  }

  public Formation getFormationByIndex(int index) {
    return this.formationRepo.getByIndex(index);
  }

  public Relation getTeacherToActivityRelationByIndex(int index) {
    return this.teacherToActivityRelationRepo.getByIndex(index);
  }

  public Relation getFormationToActivityRelationByIndex(int index) {
    return this.formationToActivityRelationRepo.getByIndex(index);
  }

  public Relation getRoomToActivityRelationByIndex(int index) {
    return this.roomToActivityRelationRepo.getByIndex(index);
  }

  public void updateTeacherByIndex(int index, String name) {
    Teacher currentTeacher = this.teacherRepo.getByIndex(index);
    currentTeacher.setName(name);
    this.teacherRepo.setAtIndex(currentTeacher, index);
  }

  public void updateActivityByIndex(int index, String name) {
    Activity currentActivity = this.activityRepo.getByIndex(index);
    currentActivity.setName(name);
    this.activityRepo.setAtIndex(currentActivity, index);
  }

  public void updateDisciplineByIndex(int index, String name) {
    Discipline currentDiscipline = this.disciplineRepo.getByIndex(index);
    currentDiscipline.setName(name);
    this.disciplineRepo.setAtIndex(currentDiscipline, index);
  }

  public void updateRoomByIndex(int index, String name) {
    Room currentRoom = this.roomRepo.getByIndex(index);
    currentRoom.setName(name);
    this.roomRepo.setAtIndex(currentRoom, index);
  }

  public void updateFormationByIndex(int index, String name) {
    Formation currentFormation = this.formationRepo.getByIndex(index);
    currentFormation.setName(name);
    this.formationRepo.setAtIndex(currentFormation, index);
  }

  public void updateTeacherToActivityRelationByIndex(int index, String keyA, String keyB) {
    Relation currentRelation = this.teacherToActivityRelationRepo.getByIndex(index);
    currentRelation.setKeyA(keyA);
    currentRelation.setKeyB(keyB);
    this.teacherToActivityRelationRepo.setAtIndex(currentRelation, index);
  }

  public void updateFormationToActivityRelationByIndex(int index, String keyA, String keyB) {
    Relation currentRelation = this.formationToActivityRelationRepo.getByIndex(index);
    currentRelation.setKeyA(keyA);
    currentRelation.setKeyB(keyB);
    this.formationToActivityRelationRepo.setAtIndex(currentRelation, index);
  }

  public void updateRoomToActivityRelationByIndex(int index, String keyA, String keyB) {
    Relation currentRelation = this.roomToActivityRelationRepo.getByIndex(index);
    currentRelation.setKeyA(keyA);
    currentRelation.setKeyB(keyB);
    this.roomToActivityRelationRepo.setAtIndex(currentRelation, index);
  }

  public void deleteTeacher(int index) {
    this.teacherRepo.deleteIndex(index);
  }

  public void deleteDiscipline(int index) {
    this.activityRepo.deleteIndex(index);
  }

  public void deleteActivity(int index) {
    this.disciplineRepo.deleteIndex(index);
  }

  public void deleteRoom(int index) {
    this.roomRepo.deleteIndex(index);
  }

  public void deleteFormation(int index) {
    this.formationRepo.deleteIndex(index);
  }

  public void deleteTeacherToActivityRelation(int index) { this.teacherToActivityRelationRepo.deleteIndex(index); }

  public void deleteFormationToActivityRelation(int index) { this.formationToActivityRelationRepo.deleteIndex(index); }

  public void deleteRoomToActivityRelation(int index) { this.formationToActivityRelationRepo.deleteIndex(index); }

  public ArrayList<Teacher> getSortedTeachersByRank(String rank) {
    ArrayList<Teacher> teachers = this.teacherRepo.getAllEntries();

    Stream<Teacher> teacherStream = teachers.stream()
            .filter(t -> t.getRank().equals(rank))
            .sorted(Comparator.comparing(Teacher::getName));

    ArrayList<Teacher> result = new ArrayList<Teacher>();
    teacherStream.forEach(result::add);

    return result;
  }

  public ArrayList<Relation> activitiesByRoom(String roomName) {
    ArrayList<Relation> roomToActivityRelations = this.roomToActivityRelationRepo.getAllEntries();

    Stream<Relation> activityStream = roomToActivityRelations.stream()
            .filter(t -> t.getKeyB().equals(roomName))
            .sorted(Comparator.comparing(Relation::getKeyC));

    ArrayList<Relation> result = new ArrayList<Relation>();
    activityStream.forEach(result::add);

    Map<String, String> map = new HashMap<String, String>();
    map.put("a", "Monday");
    map.put("b", "Tuesday");
    map.put("c", "Wednesday");
    map.put("d", "Thursday");
    map.put("e", "Friday");
    result.forEach(x -> x.setKeyC(map.get(x.getKeyC().split(" ")[0]) + " " + x.getKeyC().split(" ")[1]));

    return result;
  }

  public ArrayList<Relation> formationTimetable(String formationName) {
    ArrayList<Relation> formationToActivityRelations = this.formationToActivityRelationRepo.getAllEntries();

    Stream<Relation> activityStream = formationToActivityRelations.stream()
            .filter(t -> t.getKeyB().equals(formationName))
            .sorted(Comparator.comparing(Relation::getKeyA));
    ArrayList<Relation> formationActivities = new ArrayList<Relation>();
    activityStream.forEach(formationActivities::add);

    // TODO: fix bug when adding activity in result multiple times, no check if it was already added, add a flag
    // TODO: use streams for this?
    ArrayList<Relation> result = new ArrayList<Relation>();
    ArrayList<Relation> roomToActivityRelations = this.roomToActivityRelationRepo.getAllEntries();
    for (int i=0; i<formationActivities.size(); i++) { // for each activity that this formation must do
      Relation r = formationActivities.get(i);
      for (int j=0; j<roomToActivityRelations.size(); j++) {
        Relation p = roomToActivityRelations.get(j);
        if (p.getKeyA().equals(r.getKeyA())) {  // look for a room and time for that activity
          if (result.size() == 0) {
            result.add(p);
          } else {
            boolean add = true;
            for (int k = 0; k < result.size(); k++) {   // if the time is not occupied then add it to the schedule
              Relation e = result.get(k);
              if (e.getKeyC().equals(p.getKeyC())) {
                add = false;
              }
            }
            if (add) {
              result.add(p);
            }
          }
        }
      }
    }

    Map<String, String> map = new HashMap<String, String>();
    map.put("a", "Monday");
    map.put("b", "Tuesday");
    map.put("c", "Wednesday");
    map.put("d", "Thursday");
    map.put("e", "Friday");
    result.forEach(x -> x.setKeyC(map.get(x.getKeyC().split(" ")[0]) + " " + x.getKeyC().split(" ")[1]));

    return result;
  }

}
