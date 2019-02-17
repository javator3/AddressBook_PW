package pl.sda.addressbook.view;

import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pl.sda.addressbook.controller.EditPersonController;
import pl.sda.addressbook.controller.NewPersonController;
import pl.sda.addressbook.controller.RootViewController;
import pl.sda.addressbook.model.Person;
import pl.sda.addressbook.model.PersonString;

import java.io.File;
import java.io.IOException;

public class PersonView {

    private ObservableList<Person> personList = FXCollections.observableArrayList();
    Stage personStage = new Stage();

    public ObservableList<Person> getPersonList() {
        return personList;
    }

    private Stage stage;

    public PersonView(Stage stage) {
        this.stage = stage;
//        personList.add(new Person("Piotr", "Novak", "Szeroka", "Chelmno", "86-200", "123-123-123"));
//        personList.add(new Person("Marcin", "Jabadoo", "Wąska", "Bydgoszcz", "32-437", "222-987-234"));
//        personList.add(new Person("Michał", "Janicki", "Krótka", "Toruń", "87-100", "506-098-343"));
//        personList.add(new Person("Jan", "Kowalski", "Długa", "Chełmża", "91-243", "111-222-333"));

        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File("currentAddressList.json");
        PersonString[] person = null;
        try {
            person = objectMapper.readValue(file, PersonString[].class);
            for (PersonString e : person) {
                personList.add(new Person(e.getName(), e.getLastname(), e.getStreet(), e.getCity(), e.getZipCode(), e.getTelephone()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadView() {
        //poniższe tworzy dostęp do pól RootView - wiązanie się z kontrolerem
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/RootView.fxml"));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent parent = loader.getRoot();
        stage.setTitle("Address Book");
        stage.setScene(new Scene(parent, 600, 400));
        RootViewController rootViewController = loader.getController();
        rootViewController.setPersonView(this); //instancje przekazywane
        stage.show();
    }

    public void loadNewPersonView() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/NewPersons.fxml"));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent parent = loader.getRoot();

        NewPersonController newPersonController = loader.getController();
        newPersonController.setPersonView(this);
        personStage.setScene(new Scene(parent, 650, 400));
        personStage.show();
    }

    public void cancelButton() {
        personStage.close();

    }

    public void saveButtonToJson() {
        ObjectMapper mapper = new ObjectMapper();
        File file = new File("currentAddressList.json");
        try {
            mapper.writeValue(file, personList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadPersonEdit(int index) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/EditingPersonRoot.fxml"));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent parent = loader.getRoot();
        Stage stage2 = new Stage();
        stage2.setTitle("Edit New Person");
        stage2.setScene(new Scene(parent, 640, 400));
        stage2.show();
        EditPersonController editPersonController = loader.getController();
        editPersonController.setIndex(index);
        editPersonController.setPersonView(this);

    }
}
