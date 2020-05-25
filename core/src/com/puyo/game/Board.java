package com.puyo.game;

import java.util.ArrayList;
import java.util.Random;

public class Board {
    //Initializes the random variable used for RNG
    Random random = new Random();
    //Initializes the ArrayList used for the pairPreview
    private ArrayList<PuyoPair> pairPreview = new ArrayList<PuyoPair>();
    //Initializes the 2D array used to represent the board
    private int[][] board = new int[8][14];
    //Initializes the active PuyoPair variable
    private PuyoPair activePuyoPair;
    //Initializes the failstate variable
    boolean failstate = false;

    public Board() {
        //Fills the board with -1s to signify it is empty
        setBoard(-1);
    }

    //Generates one PuyoPair and adds it to pairPreview
    private void generatePair() {
        //TODO: Generate one pair and add it to the piece preview Arraylist
        int topPuyo = random.nextInt(5);
        int bottomPuyo = random.nextInt(5);
        pairPreview.add(new PuyoPair(topPuyo, bottomPuyo));
    }

    //Fills pairPreview with 2 PuyoPairs, the maximum amount necessary at any given time
    private void fillPreview() {
        generatePair();
        generatePair();
    }

    //Pops the next PuyoPair from the pairPreview, sets it as the activePuyoPair, and adds a new PuyoPair to replace it
    private void nextPair() {
        setActivePuyoPair(pairPreview.get(0));
        pairPreview.remove(0);
        generatePair();
    }

    //Gets the activePuyoPair
    public PuyoPair getActivePuyoPair() {
        return activePuyoPair;
    }

    //Sets the activePuyoPair
    public void setActivePuyoPair(PuyoPair puyoPair) {
        this.activePuyoPair = puyoPair;
    }
    //Fills the board with the given element
    public void setBoard(int element) {
        for(int r = 0; r < board.length; r++) {
            for(int c = 0; c < board[0].length; c++) {
                board[r][c] = element;
            }
        }
    }
    
    //Sets the coordinates of the activePuyoPair
    public void setActivePuyoPairPos(int topR, int topC, int botR, int botC) {
        //TODO: Make a setter for a PuyoPair's position
    }
}