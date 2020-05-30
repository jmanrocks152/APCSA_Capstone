package com.puyo.game;

import java.util.ArrayList;
import java.util.Random;

import sun.invoke.empty.Empty;

public class Board {
    //Initializes the constants that define the dimensions of the standard board
    private static final int boardRowsStandard = 12;
    private static final int boardColsStandard = 6;
    //Initializes the random variable used for RNG
    Random random = new Random();
    //Initializes the ArrayList used for the pairPreview
    private ArrayList<PuyoPair> pairPreview = new ArrayList<PuyoPair>();
    //TODO: Rewrite to make the board a 2D array of Puyos
    //Initializes the 2D array used to represent the board
    private Puyo[][] board = new Puyo[14][8];
    //Initializes the active PuyoPair variable
    private PuyoPair activePuyoPair;
    //Initializes the failState variable
    boolean failState = false;
    //Initializes a new Color enum
    //TODO:
    //Initializes an empty placeholder Puyo
    Puyo emptyPuyo = new Puyo(Puyo.Color.EMPTY);

    public Board() {
        //Fills the board with -1s to signify it is empty
        //TODO: Check enum implementation
        setBoard(emptyPuyo);
    }

    //Generates one PuyoPair and adds it to pairPreview
    private void generatePair() {
        int topPuyoColorInt = random.nextInt(5);
        int bottomPuyoColorInt = random.nextInt(5);
        //TODO: Fix this
        pairPreview.add(new PuyoPair(new Puyo()));
    }

    private void generatePair(int n) {
        for(int i = 0; i < n; i++) {
            int topPuyoColorInt = random.nextInt(5);
            int bottomPuyoColorInt = random.nextInt(5);
            Puyo topPuyo = new Puyo()
            //TODO:
            pairPreview.add(new PuyoPair());
        }
    }

    //Fills pairPreview with 2 PuyoPairs, the maximum amount necessary at any given time
    private void fillPreview() {
        generatePair(2);
        nextPair();
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
    public void setBoard(Puyo element) {
        for(int r = 0; r < board.length; r++) {
            for(int c = 0; c < board[0].length; c++) {
                board[r][c] = element;
            }
        }
    }

    //TODO: Rewrite with new methods
    //Sets the coordinates of the activePuyoPair
    public void setActivePuyoPairPos(int topR, int topC, int botR, int botC) {
    }

    //Sets the row coordinates of the active PuyoPair
    public void setActivePuyoPairRowPos(int topR, int botR) {

    }

    //TODO: Change bounds to reflect the top being index 1
    //Gets the lowest open row of a column
    public int getLowestRow(int c) {
        if(board[6][c] == emptyPuyo) {
            for(int r = 5; r > 0; r--) {
                if(board[r][c] == emptyPuyo) {
                    return r;
                }
            }
        }

        else {
            for(int r = 12; r > 6; r--) {
                if(board[r][c] == emptyPuyo) {
                    return r;
                }
            }
        }
    }

    //Converts a Puyo's row coordinate to pixels
    private int rowToPixels(int r) {
        return 64 * r + 64 * 2;
    }

    //Converts a Puyo's column coordinate to pixels
    private int colToPixels(int c) {
        return 64 * c + 64 * 12;
    }

    //Moves a PuyoPair one coordinate to the right, unless it is at the rightmost border, in which case it will do nothing
    private void moveOneRight() {
    }

    //TODO: Write movement methods that shift the puyo pair based on the input

    //TODO: Write method that shifts PuyoPair up if [2][3] is occupied

    //TODO: Write method thath makes Puyos fall on pop

    //TODO: Write 4 adjacency check method
}