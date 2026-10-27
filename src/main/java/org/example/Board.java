package org.example;

import java.util.Random;

public class Board {

    private static final int NUM_ROWS = 5;
    private static final int NUM_COLS = 5;
    private static final int NUM_WEAPON_TYPES = 5;

    private int[][] board = new int[NUM_ROWS][NUM_COLS];
    private Random rand = new Random();

    public void generateBoard() {
        for (int i = 0; i < NUM_ROWS; i++) {
            for (int j = 0; j < NUM_COLS; j++) {
                board[i][j] = rand.nextInt(NUM_WEAPON_TYPES);
            }
        }
    }

    public void swapWeapons(int weapon1Row, int weapon1Col, int weapon2Row, int weapon2Col) {
        int tempWeapon = board[weapon1Row][weapon1Col];
        board[weapon1Row][weapon1Col] = board[weapon2Row][weapon2Col];
        board[weapon2Row][weapon2Col] = tempWeapon;
    }

    public int[][] getBoard() {
        return board;
    }
}
