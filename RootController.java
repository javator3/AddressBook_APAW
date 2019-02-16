package pl.sda.addressbook;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import pl.sda.addressbook.model.AddressData;
import pl.sda.addressbook.view.PersonView;

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
    @FXML
    private TableView<AddressData> addressDataTableView;
    @FXML
    private TableColumn<AddressData, String> nameCol;
    @FXML
    private TableColumn<AddressData, String> lastNameCol;

    private PersonView personView;

    public void setPersonView (PersonView personView) {
        this.personView = personView;
        addressDataTableView.setItems(personView.getAddressData());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
nameCol.setCellValueFactory(n -> n.getValue().nameProperty());
lastNameCol.setCellValueFactory(l -> l.getValue().lastNameProperty());


    }
}
