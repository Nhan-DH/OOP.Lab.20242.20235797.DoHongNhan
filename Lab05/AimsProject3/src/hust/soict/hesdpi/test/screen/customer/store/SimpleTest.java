package hust.soict.hesdpi.test.screen.customer.store;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class SimpleTest extends Application {
    @Override
    public void start(Stage stage) {
        Label label = new Label("Hello JavaFX!");
        stage.setScene(new Scene(new StackPane(label), 300, 200));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}