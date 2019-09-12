package com.example.bowling.Frames;

import com.example.bowling.Roll.Roll;

public class Frame {

    private Roll firstRole;
    private Roll secondRoll;
    private int score;

    public Frame(Roll firstRoll, Roll secondRoll){
        this.firstRole = firstRoll;
        this.secondRoll = secondRoll;
    }

    public boolean isStrike(){
        return false;
    }

    public boolean isSpare(){
        return false;
    }
}
