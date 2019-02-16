package pl.sda.addressbook.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class PersonView {

    private Stage stage;

    public PersonView(Stage stage) {
        this.stage = stage;
    }

    public void loadView() {
        //zaladować i wyświetlić widok rootview
        Parent root =
                null;
        try {
            root = FXMLLoader.load(
                    getClass().getResource("/RootView.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(new Scene(root, 600, 350));
        stage.show();

    }

    public void loadNewPersonView () {
        Parent root =
                null;
        try {
            root = FXMLLoader.load(
                    getClass().getResource("/NewPersons.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(new Scene(root, 700, 400));
        stage.show();
    }


}
