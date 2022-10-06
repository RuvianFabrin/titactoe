package com.ruvianfabrin.tictactoe.core;

import com.ruvianfabrin.tictactoe.Constants;
import com.ruvianfabrin.tictactoe.score.ScoreManager;
import com.ruvianfabrin.tictactoe.ui.UI;

public class Game {
    Board board = new Board();
    Player[] players = new Player[Constants.SYMBOL_PLAYERS.length];
    private int currentPlayerIndex = -1;
    private ScoreManager scoreManager;

    public void play(){
        scoreManager = createScoremanager();

        UI.printGameTitle();

        for (int i = 0; i < players.length; i++) {
            players[i] = createPlayer(i);
        }

        boolean gameEnded = false;
        Player currentPlayer = nextPlayer();
        Player winner = null;

        while (!gameEnded){
            board.print();

            boolean sequenceFound;
            try {
                sequenceFound = currentPlayer.play();
            }catch (InvalidMoveException e){
                UI.printText("ERRO: " + e.getMessage());
                continue;
            }
            if (sequenceFound){
                gameEnded = true;
                winner = currentPlayer;

            } else if (board.isFull()){
                gameEnded = true;
            }

            currentPlayer = nextPlayer();
        }
        if (winner == null){
            UI.printText("O jogo terminou empatado");
        }else {
            UI.printText("O jogador '"+ winner.getName() +"' venceu o jogo!");

            scoreManager.saveScore(winner);
        }

        board.print();
    }

    private Player createPlayer(int index){
        String name = UI.readInput("Jogador " + (index + 1) + " => ");
        char symbol = Constants.SYMBOL_PLAYERS[index];
        Player player = new Player(name, board, symbol);

        Integer score = scoreManager.getScore(player);

        if (score != null){
            UI.printText("O jogador '"+player.getName()+"' já possui " +score+ " vitória(s)!");
        }

        UI.printText("O jogador '" + name + "' vai usar o símbolo '" + symbol + "'");
        return player;
    }

    private Player nextPlayer(){
        currentPlayerIndex = (currentPlayerIndex + 1) % players.length;
        return players[currentPlayerIndex];
    }

    private ScoreManager createScoremanager(){

        return null;
    }
}
