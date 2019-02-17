package pl.sda.addressbook;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.qdox.model.expression.Add;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import lombok.Data;
import pl.sda.addressbook.model.AddressData;
import pl.sda.addressbook.view.PersonView;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
@Data
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

    public void setPersonView(PersonView personView) {
        this.personView = personView;
        addressDataTableView.setItems(personView.getAddressData());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        nameCol.setCellValueFactory(n -> n.getValue().nameProperty());
        lastNameCol.setCellValueFactory(l -> l.getValue().lastNameProperty());


    }

    public void loadNewPerson(ActionEvent actionEvent) {
        personView.loadadd();
    }


    public void saveToJson(ActionEvent actionEvent) {

        ObjectMapper objectMapper = new ObjectMapper();
        String path = "lista.json";
        File file = new File(path);
        try {
            objectMapper.writeValue(file, personView.getAddressData());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void selectedPerson(MouseEvent mouseEvent) {
        AddressData addressData = addressDataTableView.getSelectionModel().getSelectedItem();
        System.out.println(addressData);
        Name.setText(addressData.getName());
        Lastname.setText(addressData.getLastName());
        Street.setText(addressData.getStreet());
        City.setText(addressData.getCity());
        Postalcode.setText(addressData.getPostalCode());
        Telephone.setText(addressData.getTelephone());

    }

    public void editPerson(ActionEvent actionEvent) {
//        int index = addressDataTableView.getSelectionModel().getFocusedIndex();
//        AddressData addressData = addressDataTableView.getSelectionModel().getSelectedItem();
//        personView.loadPersonEdit(person, index);
//    }
    }

    public void deletePerson(ActionEvent actionEvent) {
        int index = addressDataTableView.getSelectionModel().getFocusedIndex();
        personView.getAddressData().remove(index);
    }
}
