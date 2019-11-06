package com.company.board;

import com.company.Player_die.Piece;

import java.util.ArrayList;

public class Board {

    private final int NUMBER_OF_SQUARES = 40;
    private ArrayList<Square> squaresOnBoard;
    private ArrayList<Piece> pieces;

    public Board(int numberOfTaxSquares, int taxAmount, int goSquareMoney) {
        this.squaresOnBoard = new ArrayList<>();
        initializeBoard(numberOfTaxSquares,taxAmount,goSquareMoney);
    }

    public ArrayList<Square> getSquaresOnBoard() {
        return squaresOnBoard;
    }

    public void setSquaresOnBoard(ArrayList<Square> squaresOnBoard) {
        this.squaresOnBoard = squaresOnBoard;
    }

    public Square getSquareObject(Board board, int index) {
        return board.getSquaresOnBoard().get(index);
    }

    public ArrayList<Piece> getPieces() {
        return pieces;
    }

    public void setPieces(ArrayList<Piece> pieces) {
        this.pieces = pieces;
    }

    public void initializeBoard(int numberOfTaxSquare, int taxAmount, int goSquareMoney) {
        for (int i = 0; i < NUMBER_OF_SQUARES; i++) {
            this.getSquaresOnBoard().add(null);
        }

        Square goSquare = new GoSquare("goSquare", 0, goSquareMoney);
        getSquaresOnBoard().set(goSquare.getIndex(),goSquare);

        int randomIndexNumber = 0;
        Square jail = new JailSquare("Jail", 19);
        getSquaresOnBoard().set(jail.getIndex(), jail);

        Square gotojail =  new ArrestedSquare("Arrest", 29);
        getSquaresOnBoard().set(gotojail.getIndex(),gotojail);

        for (int i = 0; i < numberOfTaxSquare;) {
            randomIndexNumber = (int) ((Math.random() * 38) + 1);

            if( getSquaresOnBoard().get(randomIndexNumber) ==  null ){
                Square taxSquare = new TaxSquare("Tax", randomIndexNumber, taxAmount);
                getSquaresOnBoard().set(randomIndexNumber,taxSquare);
                i++;
            }
        }

        for (int i = 0; i < NUMBER_OF_SQUARES   ; i++) {
            if ( getSquaresOnBoard().get(i) == null ){
                Square regularSquare =  new RegularSquare("Regular Square", i);
                getSquaresOnBoard().set(i,regularSquare);
            }
        }
    }
}
