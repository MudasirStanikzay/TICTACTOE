package com.example.tictactoe;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

class GameController {
    private Board board;
    private BoardView boardView;
    private Computer computer;
    private int playerScore, computerScore;

    public GameController() {
        board = new Board();
        boardView = new BoardView();
        computer = new Computer();
        playerScore = 0;
        computerScore = 0;
        initialize();
    }

    private void initialize() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                final int r = row, c = col;
                boardView.getCell(row, col).setOnAction(e -> playerMove(r, c));
            }
        }
    }

    private void playerMove(int row, int col) {
        if (board.makeMove(row, col)) {
            boardView.getCell(row, col).setText("X");
            checkGameState();
            computerMove();
        }
    }

    private void computerMove() {
        int[] move = computer.getRandomMove(board);
        board.makeMove(move[0], move[1]);
        boardView.getCell(move[0], move[1]).setText("O");
        checkGameState();
    }

    private void checkGameState() {
        char result = board.checkWinner();
        if (result != ' ') {
            String message;
            if (result == 'X') {
                message = "Player Wins!";
                playerScore++;
            } else if (result == 'O') {
                message = "Computer Wins!";
                computerScore++;
            } else {
                message = "It's a draw!";
            }
            showAlert(message);
            board.reset();
            boardView.reset();
        }
    }

    private void showAlert(String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText(message + "\nPlayer Score: " + playerScore + " - Computer Score: " + computerScore);
        alert.showAndWait();
    }

    public BoardView getBoardView() {
        return boardView;
    }
}