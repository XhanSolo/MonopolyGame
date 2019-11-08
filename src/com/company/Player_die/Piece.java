package com.company.Player_die;

import com.company.board.Board;
import com.company.board.Square;

public class Piece {
    private Square square;
    private int location;
    private String name;
    private int jailCounter = 0;
    private boolean inJail = false;
    private Square currentSquare;

    public Piece(String name){
        this.name = name;
        location = 0;
    }

    public void moveTo(int dice_Value, Board board){
        location += dice_Value;
        if(location >= 40){
            location -= 40;
        }
          this.square = board.getSquareObject(board, location);
    }

    public void setFree(){
        if(getJailCounter() == 0){
            setInJail(false);
            resetJailCounter();
        }

    }


    public Square getCurrentSquare() {
        return currentSquare;
    }

    public void setCurrentSquare(Square currentSquare) {
        this.currentSquare = currentSquare;
    }

    public void decreaseJailCounter() {
        setJailCounter(getJailCounter() - 1);
    }

    public void resetJailCounter() {
        setJailCounter(0);
    }

    public int getJailCounter() {
        return jailCounter;
    }

    public void setJailCounter(int jailCounter) {
        this.jailCounter = jailCounter;
    }

    public boolean isInJail() {

        return inJail;
    }

    public void setInJail(boolean inJail) {
        this.inJail = inJail;
    }

    public Square getSquare(){
        return this.square;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
