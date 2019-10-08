package controller;

import domain.Activity;
import domain.Discipline;
import domain.Teacher;
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

  public void addDiscipine(String name) {
    Discipline newDiscipline = new Discipline(name);
    this.disciplineRepo.addEntry(newDiscipline);
  }
}
