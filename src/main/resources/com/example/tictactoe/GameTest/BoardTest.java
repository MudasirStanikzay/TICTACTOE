package com.example.tictactoe;

import javafx.application.Platform;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BoardTest {
    private Board board;

    @BeforeEach
    void setUp() {
        board = new Board(); // Skapar ett nytt spelbräde för varje test
    }

    @Test
    void testMakeMove() {
        // Gör ett giltigt drag på brädet
        assertTrue(board.makeMove(0, 0), "Första draget borde vara giltigt");
        assertEquals('O', board.getCurrentPlayer(), "Nästa spelare borde vara 'O' efter att 'X' har spelat");

        // Testar ett ogiltigt drag (samma position)
        assertFalse(board.makeMove(0, 0), "Drag på en redan använd ruta borde vara ogiltigt");
    }

    @Test
    void testCheckWinnerRow() {
        // Gör drag som resulterar i en vinnande rad för 'X'
        board.makeMove(0, 0); // X
        board.makeMove(1, 0); // O
        board.makeMove(0, 1); // X
        board.makeMove(1, 1); // O
        board.makeMove(0, 2); // X

        assertEquals('X', board.checkWinner(), "Spelare 'X' borde vinna med en rad på översta raden");
    }

    @Test
    void testCheckDraw() {
        // Simulerar ett oavgjort spel
        board.makeMove(0, 0); // X
        board.makeMove(0, 1); // O
        board.makeMove(0, 2); // X
        board.makeMove(1, 1); // O
        board.makeMove(1, 0); // X
        board.makeMove(1, 2); // O
        board.makeMove(2, 1); // X
        board.makeMove(2, 0); // O
        board.makeMove(2, 2); // X

        assertEquals('D', board.checkWinner(), "Spelresultatet borde bli oavgjort ('D') när alla rutor är fyllda utan en vinnare");
    }
}

class BoardViewTest {

    private BoardView boardView;

    @BeforeEach
    void setUp() {
        Platform.startup(() -> boardView = new BoardView()); // Starta JavaFX och skapa BoardView
    }

    @Test
    void testReset() {
        Platform.runLater(() -> {
            // Sätt celler med text
            boardView.getCell(0, 0).setText("X");
            boardView.getCell(1, 1).setText("O");

            // Utför reset
            boardView.reset();

            // Kontrollera cellerna efter reset
            for (int row = 0; row < 3; row++) {
                for (int col = 0; col < 3; col++) {
                    assertEquals("", boardView.getCell(row, col).getText(), "Cellen bör vara tom efter reset");
                    assertFalse(boardView.getCell(row, col).isDisabled(), "Cellen bör vara aktiverad efter reset");
                }
            }
        });
    }
}

class ComputerTest {

    private Computer computer;
    private Board board;

    @BeforeEach
    void setUp() {
        computer = new Computer();
        board = new Board();
    }

    @Test
    void testGetRandomMove() {
        // Begär ett drag från datorn
        int[] move = computer.getRandomMove(board);

        // Kontrollera att draget är inom spelplanens gränser
        assertTrue(move[0] >= 0 && move[0] < 3, "Radvärdet bör vara mellan 0 och 2");
        assertTrue(move[1] >= 0 && move[1] < 3, "Kolumnvärdet bör vara mellan 0 och 2");

        // Kontrollera att draget gjordes på en tom plats
        assertEquals(' ', board.getGrid()[move[0]][move[1]], "Positionen bör vara tom");
    }
}