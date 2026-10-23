package org.example;

import java.io.IOException;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

public class GameController {

    @FXML
    private GridPane boardGrid;

    private Board board;

    public GameController() {
        this.board = new Board();
    }

    @FXML
    private void initialize() {
        board.generateBoard(); // generate random arrangement of weapons on the board
        ObservableList<Node> weapons = boardGrid.getChildren();

        // Iterate through weapon nodes and set the label to the corresponding random number generated
        for (Node weapon : weapons) {
            int row_index = (GridPane.getRowIndex(weapon) == null) ? 0 : GridPane.getRowIndex(weapon);
            int col_index = (GridPane.getColumnIndex(weapon) == null) ? 0 : GridPane.getColumnIndex(weapon);

            if (weapon instanceof Label) {
                Label weaponLabel = (Label) weapon;
                weaponLabel.setText(Integer.toString(board.getBoard()[row_index][col_index]));
            }
        }
    }


    @FXML
    private void switchToHomeScreen() throws IOException {
        App.setRoot("home_screen");
    }

    @FXML
    private void onWeaponClicked(MouseEvent event) throws IOException {
        Label weapon = (Label) event.getSource();
        weapon.setText("Weapon clicked");
    }
}