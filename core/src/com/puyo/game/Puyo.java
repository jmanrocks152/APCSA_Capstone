package com.puyo.game;

public class Puyo {
    //Instance variable representing a singular puyo's color
    private String color;

    //Constructor that sets a puyo's color
    public Puyo(String color) {
        this.color = color;
    }

    //Gets a puyo's color
    public String getColor() {
        return color;
    }

    //Sets a puyo's color
    public void setColor(String color) {
        this.color = color;
    }

    //Creates an enum linking colors to integers
    public enum color {
        RED, GREEN, BLUE, YELLOW, PURPLE
    }
}
