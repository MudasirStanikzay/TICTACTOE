package com.example.tictactoe;

import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;

public class BoardView extends GridPane {
    private Button[][] cells;

    public BoardView() {
        cells = new Button[3][3];
        initialize();
    }

    private void initialize() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                Button cell = new Button();
                cell.setPrefSize(100, 100);
                cells[row][col] = cell;
                add(cell, col, row);
            }
        }
    }

    public Button getCell(int row, int col) {
        return cells[row][col];
    }

    public void reset() {
        for (Button[] row : cells) {
            for (Button cell : row) {
                cell.setText("");
                cell.setDisable(false);
            }
        }
    }
}