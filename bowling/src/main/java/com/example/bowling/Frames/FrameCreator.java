package com.example.bowling.Frames;

import com.example.bowling.Roll.Roll;

public interface FrameCreator {

    Frame createFrame(Roll firstRoll, Roll secondRoll);
}
