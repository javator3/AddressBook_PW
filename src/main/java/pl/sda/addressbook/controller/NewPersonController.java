package pl.sda.addressbook.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

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





    @Override
    public void initialize(URL location, ResourceBundle resources) {


    }
}
