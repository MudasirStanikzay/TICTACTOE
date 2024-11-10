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