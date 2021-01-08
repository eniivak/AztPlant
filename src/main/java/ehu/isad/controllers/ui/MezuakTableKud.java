package ehu.isad.controllers.ui;

import ehu.isad.App;
import ehu.isad.model.Mezua;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class MezuakTableKud {
    private App main;
    @FXML
    private Button idBotoia;
    @FXML
    private TableView<Mezua> idTable;

    @FXML
    private TableColumn<Mezua, String> idFrom;

    @FXML
    private TableColumn<Mezua, String>idTo;

    @FXML
    private TableColumn<Mezua, String>idMessage;

    @FXML
    void datuBaseanGorde(ActionEvent event) {

    }

    public void setMainApp(App main) {
        this.main=main;
    }
}