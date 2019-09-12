package com.example.bowling.Frames;

import com.example.bowling.Roll.Roll;

public class SimpleFrame extends Frame {

    SimpleFrame(Roll firstRoll, Roll secondRoll) {
        super(firstRoll, secondRoll);
    }

    @Override
    public boolean isStrike() {
        return false;
    }

    @Override
    public boolean isSpare() {
        return false;
    }
}
