package controller;

import domain.Activity;
import domain.Discipline;
import domain.Teacher;
import java.util.ArrayList;
import repository.Repository;


public class Controller {
  private Repository<Activity> activityRepo;
  private Repository<Discipline> disciplineRepo;
  private Repository<Teacher> teacherRepo;

  public Controller() {
    this.activityRepo = new Repository<Activity>();
    this.disciplineRepo = new Repository<Discipline>();
    this.teacherRepo = new Repository<Teacher>();
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

  public ArrayList<Teacher> getAllTeachers() {
    return this.teacherRepo.getAllEntries();
  }

  public ArrayList<Activity> getAllActivities() {
    return this.activityRepo.getAllEntries();
  }

  public ArrayList<Discipline> getAllDisciplines() {
    return this.disciplineRepo.getAllEntries();
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

  public void deleteTeacher(int index) { this.teacherRepo.deleteIndex(index); }

  public void deleteDiscipline(int index) { this.activityRepo.deleteIndex(index); }

  public void deleteActivity(int index) { this.disciplineRepo.deleteIndex(index); }
}
