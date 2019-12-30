import controller.Controller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {

  @Override
  public void start(Stage primaryStage) throws Exception{
    FXMLLoader loader = new FXMLLoader(getClass().getResource("fxGui.fxml"));
    Controller controller = new Controller();

    controller.addTeacher("Teacher 0", "lecturer");
    controller.addTeacher("Teacher 1", "lecturer");
    controller.addTeacher("Teacher 2", "professor");
    controller.addTeacher("Teacher 3", "professor");
    controller.addTeacher("Teacher 4", "dean");

    controller.addDiscipline("Discipline 0");
    controller.addDiscipline("Discipline 1");
    controller.addDiscipline("Discipline 2");
    controller.addDiscipline("Discipline 3");
    controller.addDiscipline("Discipline 4");

    controller.addActivity("Activity 0");
    controller.addActivity("Activity 1");
    controller.addActivity("Activity 2");
    controller.addActivity("Activity 3");
    controller.addActivity("Activity 4");

    controller.addFormation("Formation 0");
    controller.addFormation("Formation 1");
    controller.addFormation("Formation 2");
    controller.addFormation("Formation 3");
    controller.addFormation("Formation 4");

    controller.addRoom("Room 1");
    controller.addRoom("Room 2");
    controller.addRoom("Room 0");
    controller.addRoom("Room 3");
    controller.addRoom("Room 4");

    controller.addTimetableRelation(
        "Activity 1",
        "Room 1",
        "Teacher 1",
        "Formation 1",
        ""
    );
    controller.addTimetableRelation(
        "Activity 1",
        "Room 2",
        "Teacher 3",
        "Formation 2",
        ""
    );
    controller.addTimetableRelation(
        "Activity 1",
        "Room 0",
        "Teacher 4",
        "Formation 3",
        ""
    );

    loader.setController(controller);
    Parent root = (Parent)loader.load();

    primaryStage.setTitle("Patients and doctors");
    primaryStage.setScene(new Scene(root));
    primaryStage.show();
  };

  public static void main(String[] args) {
      launch(args);
    }
}

/*
  TODO: drag and drop
  TODO: check and clean project todos
  TODO: install plugin to make it look pretty

  Make use of this:
      Map<String, String> map = new HashMap<String, String>();
    map.put("a", "Monday");
    map.put("b", "Tuesday");
    map.put("c", "Wednesday");
    map.put("d", "Thursday");
    map.put("e", "Friday");
    result.forEach(x -> x.setDateString(map.get(x.dateString.split(" ")[0]) + " " + x.dateString.split(" ")[1]));
 */