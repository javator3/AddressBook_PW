package pl.sda.addressbook.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import pl.sda.addressbook.model.Person;
import pl.sda.addressbook.view.PersonView;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class RootViewController implements Initializable {

    @FXML
    private Label nameLabel;

    @FXML
    private Label lastnameLabel;

    @FXML
    private Label streetLabel;

    @FXML
    private Label cityLabel;

    @FXML
    private Label postCodeLabel;

    @FXML
    private Label telephoneLabel;

    @FXML
    private TableView<Person> personTableView;

    @FXML
    private TableColumn<Person, String> nameCol;

    @FXML
    private TableColumn<Person, String> lastName;

    @FXML
    private Button newPerson;

    @FXML
    private Button editPerson;

    @FXML
    private Button deletePerson;

    @FXML
    private Button save;


    public PersonView personView;

    public void setPersonView(PersonView personView) {
        this.personView = personView;
        personTableView.setItems(personView.getPersonList());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nameCol.setCellValueFactory(c -> c.getValue().nameProperty());
        lastName.setCellValueFactory(c -> c.getValue().lastnameProperty());
    }

    public void loadNewPerson(ActionEvent actionEvent) throws Exception {
        personView.loadNewPersonView();
    }

    public void saveListToJSON(ActionEvent actionEvent) {

        ObjectMapper mapper = new ObjectMapper();
        File file = new File("currentAddressList.json");
        try {
            mapper.writeValue(file, personView.getPersonList());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteMarkedPerson() {
        int index = personTableView.getSelectionModel().getFocusedIndex();
        personView.getPersonList().remove(index);

    }

    public void selectedPerson (MouseEvent mouseEvent) {
        Person person = personTableView.getSelectionModel().getSelectedItem();
        nameLabel.setText(person.getName());
        lastnameLabel.setText(person.getLastname());
        streetLabel.setText(person.getStreet());
        cityLabel.setText(person.getCity());
        postCodeLabel.setText(person.getPostcode());
        telephoneLabel.setText(person.getTelephone());
    }

    public void editPerson (ActionEvent actionEvent) {
        int index = personTableView.getSelectionModel().getFocusedIndex();
        Person person = personTableView.getSelectionModel().getSelectedItem();
        personView.loadPersonEdit(index);

    }
}
