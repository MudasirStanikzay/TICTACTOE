package com.example.tictactoe;

import java.util.Random;

public class Computer {
    private Random random = new Random();

    // Generates a random move for simplicity
    public int[] getRandomMove(Board board) {
        int row, col;
        do {
            row = random.nextInt(3);
            col = random.nextInt(3);
        } while (board.getGrid()[row][col] != ' ');
        return new int[]{row, col};
    }
}