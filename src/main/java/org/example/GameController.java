package org.example;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

public class GameController {

    @FXML
    GridPane gridPane;

    @FXML
    private void switchToHomeScreen() throws IOException {
        App.setRoot("home_screen");
    }

    @FXML
    private void onWeaponClicked(MouseEvent event) throws IOException {
        ImageView weapon = (ImageView) event.getSource();
        weapon.setOpacity(1.0);
    }
}