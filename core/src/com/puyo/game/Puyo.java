package com.puyo.game;

public class Puyo {
    //Instance variable representing a singular puyo's color
    private Color color;
    private int r, c;


    //Constructor that sets a puyo's color and position
    public Puyo(Color color, int r, int c) {
        this.color = color;
        this.r = r;
        this.c = c;
    }

    public Puyo(Color color) {
        this.color = color;
        r = 0;
        c = 0;
    }

    //Gets a puyo's color
    public Color getColor() {
        return color;
    }

    //Sets a puyo's color
    public void setColor(Color color) {
        this.color = color;
    }

    //Sets a puyo's position
    public void setPos(int r, int c) {
        this.r = r;
        this.c = c;
    }

    //Gets a puyo's row
    public int getRow() {
        return r;
    }

    //Sets a puyo's row
    public void setRow(int r) {
        this.r = r;
    }

    //Gets a puyo's column
    public int getCol() {
        return c;
    }

    //SEts a puyo's column
    public void setCol(int c) {
        this.c = c;
    }

    //Creates an enum linking colors to integers
    public enum Color {
        RED, GREEN, BLUE, YELLOW, PURPLE, EMPTY;

        //Turns the given number into a Puyo Color
        private Color numberToColor(int number) {
            switch(number) {
                case 0:
                    return RED;
                case 1:
                    return GREEN;
                case 2:
                    return BLUE;
                case 3:
                    return YELLOW;
                case 4:
                    return PURPLE;
                default:
                    return EMPTY;
            }
        }

        //TODO: Implement reverse lookup
    }
}
