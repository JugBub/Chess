package com.jugbub;

import java.util.ArrayList;

public abstract class Movement {

    public static void movement(Piece piece){
        whereCanMove(piece);
    }

    static ArrayList<ArrayList<int[]>> whereCanMove(Piece piece){
        int numberOfRepetitions; // 0 = infinite ; How many times does the move repeat, ex, knight can only move to 1 square per turn while queen can move over the whole board.
        int numberOfMoves = piece.moves.length; // how many kinds of moves does the piece have.
        ArrayList<ArrayList<int[]>> possibleMoves = new ArrayList<>();//{all the functions with their coordinates in an array{all the coordinates for that function{specific coordinate}}}
        int[] movePosition; // position to be added into the possible Moves list

        for (int i = 0; i < numberOfMoves; i++) { // Does the function for every move.

            possibleMoves.add(makeNewList()); // adds a spot for every position for that function.

            numberOfRepetitions = piece.moves[i][2]; // looks at how far the piece can go.

            movePosition = getValuesFrom(piece.position); // gets the starting position for that function, which is always the piece position and since we are going to change the value for every iteration we might as well copy the value to anew variable.

            increaseArrayByArray(movePosition,piece.moves[i]); //executes the function

            if (numberOfRepetitions == 0){ // means the move is infinite
                while (isWithinTable(movePosition)){ //checks if move is within table

                    appendMovePosition(possibleMoves,movePosition,i);

                    executeTheFunction(movePosition,piece.moves[i]);
                }
            }
            else{ // move is supposed to only be used finite amount of times ex: Knight
                for (int j = 0; j < numberOfRepetitions; j++) { // executes the move by the amount of repetitions

                    if(isWithinTable(movePosition)){//checks if move is within table

                        appendMovePosition(possibleMoves,movePosition,i);

                        executeTheFunction(movePosition,piece.moves[i]);
                    }
                    else
                        break;
                }
            }
        }

        return possibleMoves;
    }

    static void executeTheFunction(int[] movePosition, int[] function){
        increaseArrayByArray(movePosition,function);// executes the function
    }

    static void appendMovePosition(ArrayList<ArrayList<int[]>> possibleMoves, int[] movePosition, int i){
        int possibleMovesLength;
        possibleMoves.get(i).add(new int[2]); // makes a spot for the position in the collection of possible moves
        possibleMovesLength = getListLength(possibleMoves.get(i)); // gets the amount of positions for the "i" move
        possibleMoves.get(i).get(possibleMovesLength-1)[0] = movePosition[0]; // appends the X position
        possibleMoves.get(i).get(possibleMovesLength-1)[1] = movePosition[1]; // appends the Y position
    }

    static boolean isWithinTable(int[] position){
        final int LOW = 1;
        final int HIGH = 8;
        final int X = position[0];
        final int Y = position[1];

        return isBetween(LOW,X,HIGH) && isBetween(LOW,Y,HIGH);
    }

    static int getListLength(ArrayList arrayList){
        return arrayList.size();
    }

    static void increaseArrayByArray(int[] a, int[] b){
        for (int i = 0; i < a.length; i++) {
            a[i] += b[i];
        }
    }

    static boolean isBetween(int low, int position, int high){
        return low <= position && position <= high;
    }

    static ArrayList<int[]> makeNewList(){
        return new ArrayList<>();
    }

    static int[] getValuesFrom(int[] position){
        return new int[]{position[0],position[1]};
    }
}
