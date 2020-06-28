package com.jugbub;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
/*	    Board board = new Board();
        System.out.println(board.n);
        Board[] objects;
        Board object;

        System.out.println(Arrays.toString(PieceList.createXPieces(0,10)));
        objects = PieceList.createXPieces(0,10);
        objects[1].n = 2;
        System.out.println(objects[0].n);*/

        int[][] positions = {{1,1},{2,2},{3,2},{4,2},{5,2},{6,2},{7,2},{8,2}};
        int[][] moves = {{0,1,0},{1,0,0}};
        int[] test = {1,1};

        PieceList pieces = new PieceList(1,positions,moves);
        Piece piece = new Piece("Pawn",positions[0],moves,null);
        piece = pieces.pieces.get(0);
        System.out.println(Arrays.toString(pieces.pieces.get(0).position));
        System.out.println(piece.position);
        System.out.println((Movement.whereCanMove(piece)));
        System.out.println(Arrays.toString(test));
        Movement.increaseArrayByArray(test, moves[0]);
        //System.out.println(Arrays.toString());
        System.out.println(Arrays.toString(test));
        System.out.println("--");
        System.out.println(Arrays.deepToString(Movement.whereCanMove(piece).get(0).toArray()));
        System.out.println("--");
    }
}
