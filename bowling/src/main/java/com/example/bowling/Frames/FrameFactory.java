package com.example.bowling.Frames;

import com.example.bowling.Roll.Roll;
import org.springframework.stereotype.Service;

@Service
public class FrameFactory implements FrameCreator{

    static final int MAX_PINS = 10;

    @Override
    public Frame createFrame(Roll firstRoll, Roll secondRoll){
        if (firstRoll.getNumberOfPins() == MAX_PINS){
            return new StrikeFrame(firstRoll, new Roll("0", firstRoll.getPlayerName()));
        }else if (firstRoll.getNumberOfPins() + secondRoll.getNumberOfPins() == MAX_PINS){
            return new SpareFrame(firstRoll, secondRoll);
        }
        return new SimpleFrame(firstRoll, secondRoll);
    }
}
