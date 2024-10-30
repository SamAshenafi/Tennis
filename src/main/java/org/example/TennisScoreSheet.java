package org.example;

public class TennisScoreSheet {

    private int playerOneScore;
    private int playerTwoScore;
    private int playerOneGamesWon;
    private int playerTwoGamesWon;
    private int playerOneSetsWon;
    private int playerTwoSetsWon;

    public TennisScoreSheet() {
        this.playerOneScore = 0;
        this.playerTwoScore = 0;
        this.playerOneGamesWon = 0;
        this.playerTwoGamesWon = 0;
        this.playerOneSetsWon = 0;
        this.playerTwoSetsWon = 0;
    }

    public void pointWonBy(String player) {
        if (player.equals("Player One")) {
            playerOneScore++;
        } else if (player.equals("Player Two")) {
            playerTwoScore++;
        }
        checkGameWin();
    }

    private void checkGameWin() {
        if (playerOneScore >= 4 && playerOneScore - playerTwoScore >= 2) {
            playerOneGamesWon++;
            resetScores();
            checkSetWin();
        } else if (playerTwoScore >= 4 && playerTwoScore - playerOneScore >= 2) {
            playerTwoGamesWon++;
            resetScores();
            checkSetWin();
        }
    }

    private void checkSetWin() {
        if (playerOneGamesWon >= 6 && playerOneGamesWon - playerTwoGamesWon >= 2) {
            playerOneSetsWon++;
            resetGames();
        } else if (playerTwoGamesWon >= 6 && playerTwoGamesWon - playerOneGamesWon >= 2) {
            playerTwoSetsWon++;
            resetGames();
        }
    }

    private void resetScores() {
        playerOneScore = 0;
        playerTwoScore = 0;
    }

    private void resetGames() {
        playerOneGamesWon = 0;
        playerTwoGamesWon = 0;
    }

    // Getter methods for testing
    public int getPlayerOneScore() { return playerOneScore; }
    public int getPlayerTwoScore() { return playerTwoScore; }
    public int getPlayerOneGamesWon() { return playerOneGamesWon; }
    public int getPlayerTwoGamesWon() { return playerTwoGamesWon; }
    public int getPlayerOneSetsWon() { return playerOneSetsWon; }
    public int getPlayerTwoSetsWon() { return playerTwoSetsWon; }
}
