package com.example.bowling;

import com.example.bowling.Frames.Frame;

import java.util.ArrayList;
import java.util.List;

public class ScoreLine {

    private List<Frame> frames;

    public ScoreLine(){
        this.frames = new ArrayList<>();
    }

    public void AddFrame(Frame frame) throws Exception {
        if (this.frames.size() < 8){
            this.frames.add(frame);
        }else{
            throw new Exception("Incorrect format in file, having more than 10 frames in a game is not possible");
        }
    }
}
