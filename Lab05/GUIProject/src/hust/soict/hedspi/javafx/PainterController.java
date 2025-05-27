package hust.soict.hedspi.javafx;

import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.event.ActionEvent;

public class PainterController {

    @FXML
    private Pane drawingAreaPane;

    @FXML
    private RadioButton penButton;

    @FXML
    private RadioButton eraserButton;

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        Color drawColor = eraserButton.isSelected() ? Color.WHITE : Color.BLACK;
        Circle newCircle = new Circle(event.getX(), event.getY(), 4, drawColor);
        drawingAreaPane.getChildren().add(newCircle);
    }

    @FXML
    void clearButtonPressed(ActionEvent event) {
        drawingAreaPane.getChildren().clear();
    }

    @FXML
    public void initialize() {
        penButton.setSelected(true); // Chọn pen mặc định
    }
}

