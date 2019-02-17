package pl.sda.addressbook;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import pl.sda.addressbook.model.AddressData;
import pl.sda.addressbook.view.PersonView;

import java.awt.event.ActionEvent;
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

    private PersonView personView;

    public void setPersonView1(PersonView personView) {
        this.personView = personView;
        Imie.setText("");
        Nazwisko.setText("");
        Ulica.setText("");
        Miasto.setText("");
        Kod.setText("");
        Tel.setText("");
    }


    public void savePerson() {

        personView.getAddressData().add(new AddressData(Imie.getText(), Nazwisko.getText(), Ulica.getText(), Miasto.getText(), Kod.getText(), Tel.getText()));


    }




    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void setCancel(javafx.event.ActionEvent actionEvent) {

        personView.getNewPersonStage().close();
    }
}
