package pl.sda.addressbook;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class AddController implements Initializable {

    @FXML
    private TextField Imie;
    @FXML
    private TextField Nazwisko;
    @FXML
    private TextField Ulica;
    @FXML
    private TextField Miasto;
    @FXML
    private TextField Kod;
    @FXML
    private TextField Tel;
    @FXML
    private Button Save;
    @FXML
    private Button Cancel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
