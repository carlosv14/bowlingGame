package com.example.bowling.Frames;

import com.example.bowling.Roll.Roll;

public class Strike extends Frame {

    public Strike(int frameNumber, Roll firstRoll, Roll secondRoll) {
        super(frameNumber, firstRoll, secondRoll);
    }

    @Override
    public boolean isStrike() {
        return true;
    }
}
