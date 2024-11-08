package com.example.tictactoe;

public class Board {
    private char[][] grid;
    private char currentPlayer;

    public Board() {
        grid = new char[3][3]; // Initialize the 3x3 board
        currentPlayer = 'X'; // Assume 'X' starts
        reset();
    }

    // Resets the board for a new game
    public void reset() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                grid[i][j] = ' '; // Empty cell
            }
        }
    }

    // Makes a move if valid, returns true if successful
    public boolean makeMove(int row, int col) {
        if (row >= 0 && row < 3 && col >= 0 && col < 3 && grid[row][col] == ' ') {
            grid[row][col] = currentPlayer;
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X'; // Switch player
            return true;
        }
        return false;
    }

    // Checks for a winner or if the board is full (draw)
    public char checkWinner() {
        // Winning conditions
        for (int i = 0; i < 3; i++) {
            if (grid[i][0] == grid[i][1] && grid[i][1] == grid[i][2] && grid[i][0] != ' ')
                return grid[i][0];
            if (grid[0][i] == grid[1][i] && grid[1][i] == grid[2][i] && grid[0][i] != ' ')
                return grid[0][i];
        }
        if (grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2] && grid[0][0] != ' ')
            return grid[0][0];
        if (grid[0][2] == grid[1][1] && grid[1][1] == grid[2][0] && grid[0][2] != ' ')
            return grid[0][2];

        // Check for draw
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[i][j] == ' ') {
                    return ' '; // Game continues
                }
            }
        }
        return 'D'; // Draw
    }

    public char getCurrentPlayer() {
        return currentPlayer;
    }

    public char[][] getGrid() {
        return grid;
    }
}