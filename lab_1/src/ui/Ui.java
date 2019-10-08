package ui;

import controller.Controller;

public class Ui {

  private Controller controller;

  public Ui() {
    this.controller = new Controller();
  }

  public void run() {
    System.out.println("Running the ui!");
    this.controller.addTeacher("Some teacher name!");
    System.out.println("Finished my job!");
  }
}
