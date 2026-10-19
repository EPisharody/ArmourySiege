package org.example;

import java.io.IOException;
import javafx.fxml.FXML;

public class HomeScreenController {

    @FXML
    private void switchToGameView() throws IOException {
        App.setRoot("game_view");
    }
}
