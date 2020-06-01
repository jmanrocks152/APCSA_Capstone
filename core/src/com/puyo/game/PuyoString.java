package com.puyo.game;

import java.util.ArrayList;

//The class representing a string of identical and orthogonally adjacent Puyos that is at least 4 long
public class PuyoString {
    //Instance variable that stores the Puyos within the PuyoString
    private ArrayList<Puyo> puyoString = new ArrayList<Puyo>();

    //Adds a Puyo to puyoString
    public void addPuyo(Puyo puyo) {
        puyoString.add(puyo);
    }

    //Removes the most recently added Puyo from puyoString
    public void removePuyo() {
        puyoString.remove(puyoString.size() - 1);
    }

    //Removes the Puyo at the given index from puyoString
    public void removePuyo(int i) {
        puyoString.remove(i);
    }

    //Clears the puyoString ArrayList
    public void clearString() {
        puyoString.clear();
    }

    //Gets the length of the puyoString ArrayList
    public int getStringLength() {
        return puyoString.size();
    }

    //Gets the Puyo within puyoString
}
