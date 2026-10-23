package org.example;

import java.util.Random;

public class Board {

    private static final int NUM_ROWS = 5;
    private static final int NUM_COLS = 5;
    private static final int NUM_CANDY_TYPES = 5;

    private int[][] board = new int[NUM_ROWS][NUM_COLS];
    private Random rand = new Random();

    public void generateBoard() {
        for (int i = 0; i < NUM_ROWS; i++) {
            for (int j = 0; j < NUM_COLS; j++) {
                board[i][j] = rand.nextInt(NUM_CANDY_TYPES);
            }
        }
    }

    public int[][] getBoard() {
        return board;
    }
}
