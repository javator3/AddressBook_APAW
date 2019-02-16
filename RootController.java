package pl.sda.addressbook;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class RootController implements Initializable {

    @FXML
    private Button New;

    @FXML
    private Button Edit;

    @FXML
    private Button Delete;

    @FXML
    private Button Save;

    @FXML
    private Label Name;

    @FXML
    private Label Lastname;

    @FXML
    private Label Street;

    @FXML
    private Label City;

    @FXML
    private Label Postalcode;

    @FXML
    private Label Telephone;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
