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

    private int selectedRow =  -1;
    private int selectedCol = -1;

    public GameController() {
        this.board = new Board();
    }

    @FXML
    private void initialize() {
        board.generateBoard(); // generate random arrangement of weapons on the board
        renderBoard();
    }


    @FXML
    private void switchToHomeScreen() throws IOException {
        App.setRoot("home_screen");
    }

    @FXML
    private void onWeaponClicked(MouseEvent event) throws IOException {
        // Get row and column number of weapon that was clicked
        int row_index = (GridPane.getRowIndex((Node) event.getSource()) == null) ? 0 : GridPane.getRowIndex((Node) event.getSource());
        int column_index = (GridPane.getColumnIndex((Node) event.getSource()) == null) ? 0 : GridPane.getColumnIndex((Node) event.getSource());

        // First weapon clicked
        if (selectedRow == -1 && selectedCol == -1) {
            selectedRow = row_index;
            selectedCol = column_index;

        // Second weapon clicked
        } else {
            board.swapWeapons(selectedRow, selectedCol, row_index, column_index);
            renderBoard();
            selectedRow = -1;
            selectedCol = -1;
        }
    }

    private void renderBoard() {
        ObservableList<Node> weapons = boardGrid.getChildren();

        // Iterate through weapon nodes and set the label to the corresponding number from board array
        for (Node weapon : weapons) {
            int row_index = (GridPane.getRowIndex(weapon) == null) ? 0 : GridPane.getRowIndex(weapon);
            int col_index = (GridPane.getColumnIndex(weapon) == null) ? 0 : GridPane.getColumnIndex(weapon);

            if (weapon instanceof Label) {
                Label weaponLabel = (Label) weapon;
                weaponLabel.setText(Integer.toString(board.getBoard()[row_index][col_index]));
            }
        }
    }
}