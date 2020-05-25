package com.puyo.game;

public class PuyoPair {
    //Instance variables representing the top and bottom Puyos in a PuyoPair
    private Puyo topPuyo, bottomPuyo;
    //Instance variables representing the position of each Puyo in a PuyoPair, with (0, 0) being the top-left corner of the board
    private int topR, topC, botR, botC;

    //Constructor that creates a PuyoPair with the given Puyos
    public PuyoPair(Puyo topPuyo, Puyo bottomPuyo) {
        this.topPuyo = topPuyo;
        this.bottomPuyo = bottomPuyo;
        topR = 0;
        topC = 2;
        botR = 1;
        botC = 2;
    }

    //Sets the position of the the top Puyo in the PuyoPair
    public void setTopPos(int r, int c) {
        this.topR = r;
        this.topC = c;
    }

    //Sets the position of the the bottom Puyo in the PuyoPair
    public void setBotPos(int r, int c) {
        this.botR = r;
        this.botC = c;
    }

    //Gets the row of the top Puyo in the PuyoPair
    public int getTopRow() {
        return topR;
    }

    //Gets the row of the bottom Puyo in the PuyoPair
    public int getBotRow() {
        return botR;
    }

    //Gets the column of the top Puyo in the PuyoPair
    public int getTopCol() {
        return topC;
    }

    //Gets the column of the bottom Puyo in the PuyoPair
    public int getBotCol() {
        return botC;
    }
}
