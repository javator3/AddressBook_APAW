package pl.sda.addressbook;

import com.thoughtworks.qdox.model.expression.Add;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import lombok.Data;
import pl.sda.addressbook.model.AddressData;
import pl.sda.addressbook.view.PersonView;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;
@Data
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
    private int index;

    public void setPersonView1(PersonView personView) {
        this.personView = personView;
        Imie.setText("");
        Nazwisko.setText("");
        Ulica.setText("");
        Miasto.setText("");
        Kod.setText("");
        Tel.setText("");
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public void savePerson() {

        AddressData addressData = personView.getAddressData().get(getIndex());
        addressData.setName(Imie.getText());

        personView.getAddressData().add(new AddressData(Imie.getText(), Nazwisko.getText(), Ulica.getText(), Miasto.getText(), Kod.getText(), Tel.getText()));


    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void setCancel(javafx.event.ActionEvent actionEvent) {

        personView.getNewPersonStage().close();
    }

    public void setAddressData (AddressData addressData){
        Imie.setText(addressData.getName());
        Nazwisko.setText(addressData.getLastName());
        Ulica.setText(addressData.getStreet());
        Miasto.setText(addressData.getCity());
        Kod.setText(addressData.getPostalCode());
        Tel.setText(addressData.getTelephone());
    }
}
