package pl.sda.addressbook.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pl.sda.addressbook.RootController;
import pl.sda.addressbook.model.AddressData;

import java.io.IOException;

public class PersonView {

    private ObservableList<AddressData> addressData = FXCollections.observableArrayList();

    public ObservableList<AddressData> getAddressData() {
        return addressData;
    }

    private Stage stage;

    public PersonView(){}

    public PersonView(Stage stage) {
        this.stage = stage;

        addressData.add(new AddressData("Andrzej", "Paw", "Jarużyńska", "Bydgoszcz", "85-732", "509098098"));
        addressData.add(new AddressData("Marek", "Kal", "Kościuszki", "Toruń", "87-100", "609854345"));
        addressData.add(new AddressData("Annna", "Mow", "Żeleńskiego", "Gdańsk", "80-172", "432546789"));
        addressData.add(new AddressData("Beata", "Hou", "Grunwaldzka", "Tczew", "83-432", "334567854"));
        addressData.add(new AddressData("Darek", "Dal", "Asnyka", "Włocławek", "87-800", "123456789"));
        addressData.add(new AddressData("Maria", "Gif", "Mickiewicza", "Ciechocinek", "87-200", "334566766"));
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

    try {
        Parent root1 = FXMLLoader.load(getClass().getResource("/add.fxml"));
        stage.setScene(new Scene(root1, 700, 400));


    } catch (IOException e) {
        e.printStackTrace();
    }


}



}
