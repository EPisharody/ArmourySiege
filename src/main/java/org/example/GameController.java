package org.example;

import java.io.IOException;
import javafx.fxml.FXML;

public class GameController {

    @FXML
    private void switchToHomeScreen() throws IOException {
        App.setRoot("home_screen");
    }
}