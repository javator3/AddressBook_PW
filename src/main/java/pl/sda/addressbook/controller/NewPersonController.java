package pl.sda.addressbook.controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pl.sda.addressbook.model.Person;
import pl.sda.addressbook.view.PersonView;

import java.net.URL;
import java.util.ResourceBundle;

public class NewPersonController implements Initializable {

    @FXML
    private TextField imie;

    @FXML
    private TextField nazwisko;

    @FXML
    private TextField ulica;

    @FXML
    private TextField miasto;

    @FXML
    private TextField kodPocztowy;

    @FXML
    private TextField numerTelefonu;

    @FXML
    private Button savButton;

    @FXML
    private Button cancelButton;

    private PersonView personView;

    public void savePerson(ActionEvent actionEvent) {

        personView.getPersonList().add(new Person(imie.getText(),
                nazwisko.getText(),
                ulica.getText(),
                miasto.getText(),
                kodPocztowy.getText(),
                numerTelefonu.getText()
        ));
    }

    public void closeWindow(ActionEvent actionEvent) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    public void setPersonView(PersonView personView) {
        this.personView = personView;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
