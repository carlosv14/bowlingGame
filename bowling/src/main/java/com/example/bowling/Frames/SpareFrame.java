package com.example.bowling.Frames;

import com.example.bowling.Roll.Roll;

public class SpareFrame extends Frame {

    SpareFrame(Roll firstRoll, Roll secondRoll) {
        super(firstRoll, secondRoll);
    }

    @Override
    public boolean isStrike() {
        return false;
    }

    @Override
    public boolean isSpare() {
        return true;
    }
}