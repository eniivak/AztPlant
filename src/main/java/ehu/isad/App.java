package ehu.isad;
import ehu.isad.controllers.ui.MezuakTableKud;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.sql.SQLException;

public class App extends Application {
    private Parent mainUI;

    private Stage stage;

    private MezuakTableKud mezuakKud;

    private Scene mainScene;

    private double x,y;

    public static void main(String[] args) {launch(args);}

    public void start(Stage primaryStage) throws IOException, SQLException {
        stage= primaryStage;
        pantailaKargatu();
        mainScene= new Scene( mainUI,800, 550);
      //  stage.initStyle(StageStyle.UNDECORATED);
        pantailamugitu();
        hasieraKargatu();
    }
    public void pantailamugitu(){
        mainUI.setOnMousePressed(event -> {
            x = event.getSceneX();
            y = event.getSceneY();
        });
        mainUI.setOnMouseDragged(event -> {
            stage.setX(event.getScreenX() - x);
            stage.setY(event.getScreenY() - y);
        });
    }
    //ghjfvu

    private void pantailaKargatu() throws IOException, SQLException {


        FXMLLoader loaderMain = new FXMLLoader(getClass().getResource("/table.fxml"));
        mainUI = (Parent) loaderMain.load();
        mezuakKud = loaderMain.getController();
        mezuakKud.setMainApp(this);
        mezuakKud.erakutsiInfo();


    }
    public void hasieraKargatu(){
        stage.setScene(mainScene);
        stage.show();
    }

}