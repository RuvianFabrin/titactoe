package com.ruvianfabrin.tictactoe.core;

import com.ruvianfabrin.tictactoe.Constants;
import com.ruvianfabrin.tictactoe.ui.UI;

public class Game {
    Board board = new Board();
    Player[] players = new Player[Constants.SYMBOL_PLAYERS.length];

    public void play(){
        UI.printGameTitle();

        board.clear();
        board.print();
    }
}
