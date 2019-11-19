import controller.Controller;
import domain.Teacher;
import guiController.guiController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ui.Ui;


//public class Main {
//  public static void main(String[] args) {
//    Ui myApplication = new Ui();
//    myApplication.run();
//  };
//}

public class Main extends Application {

  @Override
  public void start(Stage primaryStage) throws Exception{
    FXMLLoader loader = new FXMLLoader(getClass().getResource("fxGui.fxml"));
    guiController controller = new guiController();
    loader.setController(controller);
    Parent root = (Parent)loader.load();

    primaryStage.setTitle("Patients and doctors");
    primaryStage.setScene(new Scene(root, 450, 350));
    primaryStage.show();
  };

  public static void main(String[] args) {
      launch(args);
    }
}
