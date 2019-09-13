package com.example.bowling.Score;

import com.example.bowling.Frames.Frame;

import java.util.ArrayList;
import java.util.List;

public class ScoreLine {

    private List<Frame> frames;

    public ScoreLine(){
        this.frames = new ArrayList<>();
    }

    public void addFrame(Frame frame) throws Exception {
        if (this.frames.size() < 11){
            this.frames.add(frame);
        }else{
            throw new Exception("Incorrect format in file, having more than 10 frames in a game is not possible");
        }
    }

    public Frame getFrame(int currentIndex){
        return this.frames.get(currentIndex >= this.frames.size() ? this.frames.size() -1 : currentIndex);
    }
}
