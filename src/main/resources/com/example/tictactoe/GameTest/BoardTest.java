package com.example.tictactoe;

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

