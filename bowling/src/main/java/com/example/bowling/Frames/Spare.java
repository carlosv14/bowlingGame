package com.example.bowling.Frames;

import com.example.bowling.Roll.Roll;

public class Spare extends Frame {

    public Spare(int frameNumber, Roll firstRoll, Roll secondRoll) {
        super(firstRoll, secondRoll);
    }

    @Override
    public boolean isSpare() {
        return true;
    }
}