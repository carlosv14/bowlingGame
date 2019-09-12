package com.example.bowling;

import com.example.bowling.Frames.Frame;

import java.util.ArrayList;
import java.util.List;

public class ScoreLine implements Calculable {

    private List<Frame> frames;

    ScoreLine(){
        this.frames = new ArrayList<>();
    }

    void addFrame(Frame frame) throws Exception {
        if (this.frames.size() < 11){
            this.frames.add(frame);
        }else{
            throw new Exception("Incorrect format in file, having more than 10 frames in a game is not possible");
        }
    }

    @Override
    public int calculate() {
        int total = 0;
        for (int i =0; i< 10; i++){
            total += this.frames.get(i).calculate() + this.getBonusScore(i);
            this.frames.get(i).setScore(total);
        }
        return total;
    }

    private int getBonusScore(int currentIndex){
        Frame frame = this.frames.get(currentIndex);
        if (frame.isSpare()){
            return this.getSpareBonus(currentIndex);
        }

        if (frame.isStrike()){
            return this.getStrikeBonus(currentIndex);
        }

        return 0;
    }

    private int getSpareBonus(int currentIndex){
       return this.getNextFrame(currentIndex).getFirstRoll().getNumberOfPins();
    }

    private int getStrikeBonus(int currentIndex){
        Frame nextFrame = this.getNextFrame(currentIndex);
        if (nextFrame.isStrike()){
            return nextFrame.getFirstRoll().getNumberOfPins() + this.getNextFrame(currentIndex + 1).getFirstRoll().getNumberOfPins();
        }
        return nextFrame.calculate();
    }

    private Frame getNextFrame(int currentIndex){
        if (currentIndex < this.frames.size() - 1){
            return this.frames.get(currentIndex + 1);
        }
        return this.frames.get(currentIndex);
    }
}
