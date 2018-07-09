package com.kaze.models;

public  class Round {

    private int number = 1;

    public Round(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    // no need to sync
    public void nextRound() {
        number++;
    }
}