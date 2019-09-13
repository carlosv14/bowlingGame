package com.example.bowling.Frames;

import com.example.bowling.Roll.Roll;

public abstract class Frame {

    private Roll firstRoll;

    private int score;

    private Roll secondRoll;

    Frame(Roll firstRoll, Roll secondRoll){
        this.firstRoll = firstRoll;
        this.secondRoll = secondRoll;
    }

    public abstract boolean isStrike();

    public abstract boolean isSpare();


    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }


    public Roll getSecondRoll(){
        return this.secondRoll;
    }

    public Roll getFirstRoll(){
        return this.firstRoll;
    }

    public abstract String getFrameResult();

    public int calculate() {
        return this.getFirstRoll().getNumberOfPins() + this.getSecondRoll().getNumberOfPins();
    }
}
