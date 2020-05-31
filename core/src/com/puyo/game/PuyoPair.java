package com.puyo.game;

//The class representing a pair of Puyos, one piece within the game
public class PuyoPair {
    //Instance variables representing the top and bottom Puyos in a PuyoPair
    private Puyo topPuyo, bottomPuyo;
    private int orientation;
    //Instance variables representing the position of each Puyo in a PuyoPair, with (0, 0) being the top-left corner of the board

    //Constructor that creates a PuyoPair with the given Puyos
    public PuyoPair(Puyo topPuyo, Puyo bottomPuyo) {
        this.topPuyo = topPuyo;
        this.bottomPuyo = bottomPuyo;
        orientation = 0;
    }

    //Sets the position of the the top Puyo in the PuyoPair
    public void setTopPos(int r, int c) {
        topPuyo.setPos(r, c);
    }

    //Sets the position of the the bottom Puyo in the PuyoPair
    public void setBotPos(int r, int c) {
        bottomPuyo.setPos(r, c);
    }

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

    //Gets the row of the bottom Puyo in the PuyoPair
    public int getBotRow() {
        return bottomPuyo.getRow();
    }

    //Sets the column of the top Puyo in the PuyoPair
    public void setTopCol(int c) {
        topPuyo.setCol(c);
    }

    //Gets the column of the top Puyo in the PuyoPair
    public int getTopCol() {
        return topPuyo.getCol();
    }

    //Sets the column of the bottom Puyo in the PuyoPair
    public void setBotCol(int c) {
        bottomPuyo.setCol(c);
    }

    //Gets the column of the bottom Puyo in the PuyoPair
    public int getBotCol() {
        return bottomPuyo.getCol();
    }

    //Sets the orientation of the PuyoPair in degrees
    public void setOrientation(int rot) {
        orientation = rot;
    }

    //Gets the orientation of the PuyoPair
    public int getOrientation() {
        return orientation;
    }

    //Gets the color of the top Puyo in the PuyoPair
    public Puyo.Color getTopColor() {
        return topPuyo.getColor();
    }

    //Gets the color of the bottom Puyo in the PuyoPair
    public Puyo.Color getBotColor() {
        return bottomPuyo.getColor();
    }

    //Gets the top Puyo in the PuyoPair
    public Puyo getTopPuyo() {
        return topPuyo;
    }

    //Gets the bottom Puyo in the PuyoPair
    public Puyo getBotPuyo() {
        return bottomPuyo;
    }
}
