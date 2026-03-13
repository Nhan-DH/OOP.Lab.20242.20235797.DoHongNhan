package hust.soict.hesdpi.aims.screen.customer.controller;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;

public class PlayMediaController {

    private String mediaTitle;

    
    public PlayMediaController(String mediaTitle) {
    	 this.mediaTitle = mediaTitle;
	}


	public void show() {
        Stage stage = new Stage();
        stage.setTitle("Play Media");

        Label label = new Label("Playing: " + mediaTitle);
        label.setStyle("-fx-font-size: 20px; -fx-padding: 20px;");

        VBox root = new VBox(label);
        root.setAlignment(Pos.CENTER);

        Scene scene = new Scene(root, 300, 200);
        stage.setScene(scene);
        stage.show();
    }
}
