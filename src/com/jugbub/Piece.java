package com.jugbub;

public class Piece {
    int[] position;
    int[][] moves;
    String color;
    String name;


    public Piece(String name, int[] position, int[][] moves, String color){
        this.position = position;
        this.moves = moves;
        this.color = color;
        this.name = name;

    }
}
