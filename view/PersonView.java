package pl.sda.addressbook.view;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.qdox.model.expression.Add;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pl.sda.addressbook.AddController;
import pl.sda.addressbook.RootController;
import pl.sda.addressbook.model.AddressData;
import pl.sda.addressbook.model.AddressJson;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;

public class PersonView {

    private ObservableList<AddressData> addressData = FXCollections.observableArrayList();

    public ObservableList<AddressData> getAddressData() {
        return addressData;
    }

    private Stage stage;
    private Stage newPersonStage;

    public PersonView(){}

    public Stage getNewPersonStage() {
        return newPersonStage;
    }

    public PersonView(Stage stage) {
        this.stage = stage;


        ObjectMapper objectMapper = new ObjectMapper();
        String path = "lista.json";
        File file = new File(path);
        AddressJson[] addressJsons = null;
        try {
            addressJsons = objectMapper.readValue(file, AddressJson[].class);
           for (AddressJson a: addressJsons){
               addressData.add(new AddressData(a.getName(), a.getLastName(), a.getStreet(), a.getCity(), a.getPostalCode(), a.getTelephone()));
           }

        } catch (IOException e) {
            e.printStackTrace();
        }

//        addressData.add(new AddressData("Andrzej", "Paw", "Jarużyńska", "Bydgoszcz", "85-732", "509098098"));
//        addressData.add(new AddressData("Marek", "Kal", "Kościuszki", "Toruń", "87-100", "609854345"));
//        addressData.add(new AddressData("Annna", "Mow", "Żeleńskiego", "Gdańsk", "80-172", "432546789"));
//        addressData.add(new AddressData("Beata", "Hou", "Grunwaldzka", "Tczew", "83-432", "334567854"));
//        addressData.add(new AddressData("Darek", "Dal", "Asnyka", "Włocławek", "87-800", "123456789"));
//        addressData.add(new AddressData("Maria", "Gif", "Mickiewicza", "Ciechocinek", "87-200", "334566766"));
//    }
    }

    public void loadView(){

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/root.fxml"));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent parent = loader.getRoot();
            stage.setScene(new Scene(parent, 600, 400));

            RootController rootController = loader.getController();
            rootController.setPersonView(this);
            stage.show();


    }


    public void loadadd (){

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/add.fxml"));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent parent = loader.getRoot();

        newPersonStage = new Stage();

        newPersonStage.setScene(new Scene(parent, 600, 400));

        newPersonStage.show();

        AddController addController = loader.getController();
        addController.setPersonView1(this);

    }


    public void loadPersonEdit(AddressData addressData, int index) {



        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/add.fxml"));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent parent = loader.getRoot();

        newPersonStage = new Stage();

        newPersonStage.setScene(new Scene(parent, 600, 400));

        newPersonStage.show();

        AddController addController = loader.getController();
        addController.setPersonView1(this);
        addController.setAddressData(addressData);
        addController.setIndex(index);



    }
}
