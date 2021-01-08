package ehu.isad.controllers.ui;

import ehu.isad.App;
import ehu.isad.controllers.db.MezuaKud;
import ehu.isad.model.Mezua;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MezuakTableKud {
    private App main;
    private MezuaKud mz= MezuaKud.getInstantzia();
    private ObservableList<Mezua> lista;
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
    public void erakutsiInfo() throws SQLException {
        List<Mezua> emaitza= new ArrayList<Mezua>();
       setLista(mz.lortuMezuak());
    }

    public void setLista(List<Mezua> plista) {
        lista= FXCollections.observableArrayList();
        lista.addAll(plista);
        idTable.setItems(lista);

    }

    public void setMainApp(App main) {
        this.main=main;
    }
}