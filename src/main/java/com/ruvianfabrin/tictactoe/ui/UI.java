package com.ruvianfabrin.tictactoe.ui;

import java.util.Scanner;

public class UI {

    public static void printText(String text) {
        System.out.println(text);
    }

    public static void printTextWithNonewLine(String text){
        System.out.print(text);
    }

    public static void printNewLine(){
        System.out.println();
    }

    public static void printGameTitle(){
        printText("====================");
        printText("| JOGO DA VELHA |");
        printText("====================");
        printNewLine();
    }

    public static String readInput(String text){
        printTextWithNonewLine(text + "");
        String temp = "";
        try (Scanner ler = new Scanner(System.in)) {
            temp = ler.next();
        }
        return temp;
    }
}
