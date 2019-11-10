package controller;

import domain.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Properties;

import repository.FileRepository;


public class Controller {
  private FileRepository<Activity> activityRepo;
  private FileRepository<Discipline> disciplineRepo;
  private FileRepository<Teacher> teacherRepo;
  private FileRepository<Room> roomRepo;
  private FileRepository<Formation> formationRepo;
  private FileRepository<Relation> teacherToActivityRelationRepo;
  private FileRepository<Relation> formationToActivityRelationRepo;
  private FileRepository<Relation> roomToActivityRelationRepo;

  public Controller() {
    this.activityRepo = new FileRepository<Activity>(Activity.class, "activity.csv");
    this.disciplineRepo = new FileRepository<Discipline>(Discipline.class,"discipline.csv");
    this.teacherRepo = new FileRepository<Teacher>(Teacher.class, "teacher.csv");
    this.roomRepo = new FileRepository<Room>(Room.class,"room.csv");
    this.formationRepo = new FileRepository<Formation>(Formation.class, "formation.csv");
    this.teacherToActivityRelationRepo = new FileRepository<Relation>(Relation.class, "teacher-activity.csv");
    this.formationToActivityRelationRepo = new FileRepository<Relation>(Relation.class, "formation-activity.csv");
    this.roomToActivityRelationRepo = new FileRepository<Relation>(Relation.class, "room-activity.csv");
  }

  public void addTeacher(String name) {
    Teacher newTeacher = new Teacher(name);
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

  public void addRoomToActivityRelation(String keyA, String keyB) {
    Relation newRelation = new Relation(keyA, keyB);
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
}
