package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TennisScoreSheetTest {
    private TennisScoreSheet scoreSheet;

    @BeforeEach
    void setUp() {
        scoreSheet = new TennisScoreSheet();
    }

    @Test
    void testInitialScore() {
        assertEquals(0, scoreSheet.getPlayerOneScore());
        assertEquals(0, scoreSheet.getPlayerTwoScore());
        assertEquals(0, scoreSheet.getPlayerOneGamesWon());
        assertEquals(0, scoreSheet.getPlayerTwoGamesWon());
        assertEquals(0, scoreSheet.getPlayerOneSetsWon());
        assertEquals(0, scoreSheet.getPlayerTwoSetsWon());
    }

    @Test
    void testPointWonByPlayerOne() {
        scoreSheet.pointWonBy("Player One");
        assertEquals(1, scoreSheet.getPlayerOneScore());
        assertEquals(0, scoreSheet.getPlayerTwoScore());
    }

    @Test
    void testPointWonByPlayerTwo() {
        scoreSheet.pointWonBy("Player Two");
        assertEquals(1, scoreSheet.getPlayerTwoScore());
        assertEquals(0, scoreSheet.getPlayerOneScore());
    }

    @Test
    void testGameWonByPlayerOne() {
        scoreSheet.pointWonBy("Player One");
        scoreSheet.pointWonBy("Player One");
        scoreSheet.pointWonBy("Player One");
        scoreSheet.pointWonBy("Player One");

        assertEquals(1, scoreSheet.getPlayerOneGamesWon());
        assertEquals(0, scoreSheet.getPlayerTwoGamesWon());
        assertEquals(0, scoreSheet.getPlayerOneScore());
        assertEquals(0, scoreSheet.getPlayerTwoScore());
    }

    @Test
    void testSetWonByPlayerOne() {
        for (int i = 0; i < 6; i++) {
            simulateGameWin("Player One");
        }
        assertEquals(1, scoreSheet.getPlayerOneSetsWon());
        assertEquals(0, scoreSheet.getPlayerTwoSetsWon());
        assertEquals(0, scoreSheet.getPlayerOneGamesWon());
        assertEquals(0, scoreSheet.getPlayerTwoGamesWon());
    }

    private void simulateGameWin(String player) {
        scoreSheet.pointWonBy(player);
        scoreSheet.pointWonBy(player);
        scoreSheet.pointWonBy(player);
        scoreSheet.pointWonBy(player);
    }
}
