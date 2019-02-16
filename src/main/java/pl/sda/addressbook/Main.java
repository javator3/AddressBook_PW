package pl.sda.addressbook;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pl.sda.addressbook.view.PersonView;


public class Main extends Application {


    public static void main(String[] args) {
        // write your code here
        launch(args);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        PersonView personView = new PersonView(primaryStage);

        personView.loadView();
//        personView.loadNewPersonView();

//        Parent root =
//                FXMLLoader.load(
//                        getClass().getResource("/RootView.fxml"));
//        primaryStage.setScene(new Scene(root, 600, 350));
//        primaryStage.show();

        //wywołanie metody loadView z klasy PersonView

    }

}
