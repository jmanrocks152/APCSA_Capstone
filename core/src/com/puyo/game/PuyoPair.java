package com.puyo.game;

public class PuyoPair {
    //Instance variables representing the top and bottom Puyos in a PuyoPair
    private Puyo topPuyo, bottomPuyo;
    //Instance variables representing the position of each Puyo in a PuyoPair, with (0, 0) being the top-left corner of the board

    //Constructor that creates a PuyoPair with the given Puyos
    public PuyoPair(Puyo topPuyo, Puyo bottomPuyo) {
        this.topPuyo = topPuyo;
        this.bottomPuyo = bottomPuyo;
    }

    //Sets the position of the the top Puyo in the PuyoPair
    public void setTopPos(int r, int c) {
        topPuyo.setPos(r, c);
    }

    //Sets the position of the the bottom Puyo in the PuyoPair
    public void setBotPos(int r, int c) {
        bottomPuyo.setPos(r, c);
    }

    //TODO: Write rest of mutators
    //Sets the row of the top Puyo in the PuyoPair
    public void setTopRow(int r) {
        topPuyo.setRow(r);
    }

    //Gets the row of the top Puyo in the PuyoPair
    public int getTopRow() {
        return topPuyo.getRow();
    }

    //Sets the row of the bottom Puyo in the PuyoPair
    public void setBotRow(int r) {
        bottomPuyo.setRow(r);
    }



}
