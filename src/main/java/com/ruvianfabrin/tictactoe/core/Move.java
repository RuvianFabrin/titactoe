package com.ruvianfabrin.tictactoe.core;

public class Move {
    int i;
    int j;

    public Move(String moveStr) throws InvalidMoveException{
        try {
            // "1,2"
            //[ "1","2" ]
            String[] tokens = moveStr.split(",");

            this.i = Integer.parseInt(tokens[0]);
            this.j = Integer.parseInt(tokens[1]);
        }catch (Exception e){
            throw new InvalidMoveException("A Jogada é inválida");
        }
    }

    public int getI(){
        return i;
    }

    public int getJ(){
        return j;
    }
}
