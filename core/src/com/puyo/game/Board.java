package com.puyo.game;

import java.util.ArrayList;
import java.util.Random;

public class Board {
    //Initializes the constants that define the dimensions of the standard board
    private static final int boardRowsStandard = 12;
    private static final int boardColsStandard = 6;
    //Initializes the random variable used for RNG
    Random random = new Random();
    //Initializes the ArrayList used for the pairPreview
    private ArrayList<PuyoPair> pairPreview = new ArrayList<PuyoPair>();
    //Initializes the 2D array used to represent the board
    private Puyo[][] board = new Puyo[14][8];
    //Initializes the active PuyoPair variable
    private PuyoPair activePuyoPair;
    //Initializes the failState variable
    boolean failState = false;
    //Initializes an empty placeholder Puyo
    Puyo emptyPuyo = new Puyo(Puyo.Color.EMPTY);
    //Initializes the puyoString ArrayList, which will store strings of orthogonally adjacent Puyos
    ArrayList<Puyo> puyoString = new ArrayList<>();

    public Board() {
        //Fills the board with emptyPuyos to signify it is empty
        setBoard(emptyPuyo);
        //Fills piecePreview and calls the first PuyoPair
        fillPreview();
        nextPair();
    }

    //Generates one PuyoPair and adds it to pairPreview
    private void generatePair() {
        int topPuyoColorInt = random.nextInt(5);
        int bottomPuyoColorInt = random.nextInt(5);
        Puyo topPuyo = new Puyo(Puyo.Color.numberToColor(topPuyoColorInt), 1, 3);
        Puyo botPuyo = new Puyo(Puyo.Color.numberToColor(bottomPuyoColorInt), 2, 3);
        pairPreview.add(new PuyoPair(topPuyo, botPuyo));
    }

    private void generatePair(int n) {
        for(int i = 0; i < n; i++) {
            int topPuyoColorInt = random.nextInt(5);
            int bottomPuyoColorInt = random.nextInt(5);
            Puyo topPuyo = new Puyo(Puyo.Color.numberToColor(topPuyoColorInt), 1, 3);
            Puyo botPuyo = new Puyo(Puyo.Color.numberToColor(bottomPuyoColorInt), 2, 3);
            pairPreview.add(new PuyoPair(topPuyo, botPuyo));
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

    //Checks if the board is completely empty
    private boolean checkEmptyBoard() {
        for(int r = 0; r < board.length; r++) {
            for(int c = 0; c < board[0].length; c++) {
                if(board[r][c] != emptyPuyo) {
                    return false;
                }
            }
        }

        return true;
    }

    //Writes the active PuyoPair's Puyos into the board
    private void placePuyoPair(PuyoPair puyoPair) {
        int topCurrentRow = activePuyoPair.getTopRow();
        int topCurrentCol = activePuyoPair.getTopCol();
        int botCurrentRow = activePuyoPair.getBotRow();
        int botCurrentCol = activePuyoPair.getBotCol();

        board[topCurrentRow][topCurrentCol] = activePuyoPair.getTopPuyo();
        board[botCurrentRow][botCurrentCol] = activePuyoPair.getBotPuyo();
    }

    //Sets the coordinates of the activePuyoPair
    public void setActivePuyoPairPos(int topR, int topC, int botR, int botC) {
        activePuyoPair.setTopPos(topR, topC);
        activePuyoPair.setBotPos(botR, botC);
    }

    //Sets the row coordinates of the active PuyoPair
    public void setActivePuyoPairRows(int topR, int botR) {
        activePuyoPair.setTopRow(topR);
        activePuyoPair.setBotRow(botR);
    }

    //Sets the column coordinates of the active PuyoPair
    public void setActivePuyoPairCols(int topC, int botC) {
        activePuyoPair.setTopCol(topC);
        activePuyoPair.setBotCol(botC);
    }

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

        return -1;
    }

    //Converts a Puyo's row coordinate to pixels
    @org.jetbrains.annotations.Contract(pure = true)
    public int rowToPixels(int r) {
        return 64 * r + 64 * 2;
    }

    //Converts a Puyo's column coordinate to pixels
    @org.jetbrains.annotations.Contract(pure = true)
    public int colToPixels(int c) {
        return 64 * c + 64 * 12;
    }

    //Moves a PuyoPair one coordinate to the right, unless it is at the rightmost border, in which case it will do nothing
    public void moveOneRight() {
        int topCurrentRow = activePuyoPair.getTopRow();
        int topCurrentCol = activePuyoPair.getTopCol();
        int topNextCol = topCurrentCol + 1;
        int botCurrentRow = activePuyoPair.getBotRow();
        int botCurrentCol = activePuyoPair.getBotCol();
        int botNextCol = botCurrentCol + 1;

        boolean topValidMove = false;
        boolean botValidMove = false;

        if(topCurrentCol != 6 && board[topCurrentRow][topNextCol] == emptyPuyo) {
            topValidMove = true;
        }

        if(botCurrentCol != 6 && board[botCurrentRow][botNextCol] == emptyPuyo) {
            botValidMove = true;
        }

        if(topValidMove && botValidMove) {
            activePuyoPair.setTopCol(topNextCol);
            activePuyoPair.setBotCol(botNextCol);
        }
    }

    //Moves a PuyoPair one coordinate to the left, unless it is at the leftmost border, in which case it will do nothing
    public void moveOneLeft() {
        int topCurrentRow = activePuyoPair.getTopRow();
        int topCurrentCol = activePuyoPair.getTopCol();
        int topNextCol = topCurrentCol - 1;
        int botCurrentRow = activePuyoPair.getBotRow();
        int botCurrentCol = activePuyoPair.getBotCol();
        int botNextCol = botCurrentCol - 1;

        boolean topValidMove = false;
        boolean botValidMove = false;

        if(topCurrentCol != 1 && board[topCurrentRow][topNextCol] == emptyPuyo) {
            topValidMove = true;
        }

        if(botCurrentCol != 1 && board[botCurrentRow][botNextCol] == emptyPuyo) {
            botValidMove = true;
        }

        if(topValidMove && botValidMove) {
            activePuyoPair.setTopCol(topNextCol);
            activePuyoPair.setBotCol(botNextCol);
        }
    }

    //TODO: Make a switch for the currentOrientation, add cases for orientation = 180, 270
    //Rotates the PuyoPair 90 degrees to the right, shifting the PuyoPair to the left if attempted at the rightmost border
    public void rotate90Right() {
        int currentOrientation = activePuyoPair.getOrientation();
        int topCurrentRow = activePuyoPair.getTopRow();
        int topCurrentCol = activePuyoPair.getTopCol();
        int botCurrentRow = activePuyoPair.getBotRow();
        int botCurrentCol = activePuyoPair.getBotCol();

        if(currentOrientation == 0) {
            if(topCurrentCol == 6) {
                setActivePuyoPairPos(topCurrentRow + 1, topCurrentCol, botCurrentRow, botCurrentCol - 1);
            }

            else {
                activePuyoPair.setTopPos(topCurrentRow + 1, topCurrentCol + 1);
                activePuyoPair.setOrientation(90);
            }
        }

        if(currentOrientation == 90) {
            activePuyoPair.setTopPos(topCurrentRow + 1, topCurrentCol - 1);
            activePuyoPair.setOrientation(0);
        }
    }

    //Hard drops the PuyoPair's Puyos into the lowest rows of the board that are unoccupied
    public void hardDrop() {
        int topCurrentCol = activePuyoPair.getTopCol();
        int botCurrentCol = activePuyoPair.getBotCol();

        int topLowestRow = getLowestRow(topCurrentCol);
        int botLowestRow = getLowestRow(botCurrentCol);

        setActivePuyoPairPos(topLowestRow, topCurrentCol, botLowestRow, botCurrentCol);
        placePuyoPair(activePuyoPair);
    }

    //Makes the Puyos in a given column fall the given amount of units
    private void fallColumn(int c, int highestEmptyRow, int puyosPopped) {
        int r = highestEmptyRow + 1;
        int currentRow;

        while(board[r][c] != emptyPuyo) {
            currentRow = board[r][c].getRow();
            board[r][c].setRow(currentRow - puyosPopped);
        }
    }

    //Checks if a perfect clear has been obtained
    public boolean checkPC() {
        if(checkEmptyBoard()) {
            return true;
        }

        else {
            return false;
        }
    }

    //Pops the Puyo at the given coordinates
    private void popPuyo(Puyo puyo) {
        int currentRow = puyo.getRow();
        int currentColumn = puyo.getCol();
        board[currentRow][currentColumn] = emptyPuyo;
    }

    //Pops a given PuyoString, making them fall as necessary
    private void popPuyoString() {
        int previousCol = 0;
        int currentCol, currentRow, highestRow;
        while(puyoString.isEmpty() == false) {
            currentCol = puyoString.get(0).getCol();
            currentRow = puyoString.get(0).getRow();

            if(currentCol != previousCol) {
                highestRow = 0;
            }

            if()
        }
    }

    //TODO: Checks the board for any strings of 4 or greater adjacent orthogonally to each other

    //TODO: Write game over check

    //TODO: Write method that shifts PuyoPair up if [2][3] is occupied

    //TODO: Write method that makes Puyos fall on pop

    //TODO: Write 4 adjacency check method

    //TODO: Write method that moves preview
}