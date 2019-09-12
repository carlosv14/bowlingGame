package com.example.bowling.Frames;

import com.example.bowling.Roll.Roll;

public class StrikeFrame extends Frame {

    StrikeFrame(Roll firstRoll, Roll secondRoll) {
        super(firstRoll, secondRoll);
    }

    @Override
    public boolean isStrike() {
        return true;
    }

    @Override
    public boolean isSpare() {
        return false;
    }
}
