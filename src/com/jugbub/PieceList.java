package com.jugbub;

import java.util.ArrayList;

public class PieceList extends Board {
    ArrayList<Piece> pieces;
    int numberUniqueOfPieces;
    int[][] positions = {{2,1},{2,2},{2,3},{2,4},{2,5},{2,6},{2,7},{2,8}};
    int[][] moves = {{0,1,1}};

    public PieceList(int numberOfUniquePieces,int[][] positions, int[][] moves){
        this.positions = positions;
        this.moves = moves;
        this.pieces = pieceList(numberOfUniquePieces,positions,moves);
    }

    static ArrayList<Piece> pieceList (int numberOfUniquePieces,int[][] positions, int[][] moves){
        ArrayList<Piece> a = createXPieces(8,"Pawn", positions, moves,"White");
        return a;
    }

    static ArrayList<Piece> createXPieces(int x, String name, int[][] position, int[][] moves, String color){
        ArrayList<Piece> pieces = new ArrayList<>();
        for (int i = 0; i < x; i++) {
            pieces.add(new Piece(name, position[i], moves, color));

        }

        return pieces;
    }


}
