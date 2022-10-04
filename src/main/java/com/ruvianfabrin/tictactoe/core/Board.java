package com.ruvianfabrin.tictactoe.core;

import com.ruvianfabrin.tictactoe.Constants;
import com.ruvianfabrin.tictactoe.ui.UI;

public class Board {
    char[][] matrix = new char[Constants.BOARD_SIZE][Constants.BOARD_SIZE];

    public Board(){
        clear();
    }
    public void clear(){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = ' ';
            }
        }
    }
    public void print(){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                UI.printTextWithNonewLine(String.valueOf(matrix[i][j]));
                if (j<matrix[i].length-1) {
                    UI.printTextWithNonewLine(" | ");
                }
            }
            UI.printNewLine();
            if (i<matrix.length-1) {
                UI.printText("---------");
            }
        }
    }
    public boolean isFull(){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == ' '){
                    return false;
                }
            }
        }
        return true;
    }

    public void play(){

    }

}
