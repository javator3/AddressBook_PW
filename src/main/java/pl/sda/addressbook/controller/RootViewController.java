package pl.sda.addressbook.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import pl.sda.addressbook.model.Person;

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
    private Label postalCodeLabel;

    @FXML
    private Label telephoneLabel;

    @FXML
    private TableView<Person> personTableView;

    @FXML
    private TableColumn<Person, String> nameCol;

    @FXML
    private TableColumn<Person, String> lastName;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
