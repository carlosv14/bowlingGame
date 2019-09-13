package com.example.bowling.Score;

import com.example.bowling.Frames.Frame;
import com.example.bowling.Frames.FrameCreator;
import com.example.bowling.Roll.Roll;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class Scorer implements ScoreBuilder {

    private Map<String, ScoreLine> scores;
    private FrameCreator frameFactory;
    static final int MAX_PINS = 10;

    public Scorer(FrameCreator frameFactory){
        this.scores = new HashMap<>();
        this.frameFactory = frameFactory;
    }

    public void addScore(Roll firstRoll, Roll secondRoll) throws Exception {
        Frame frame =  this.frameFactory.createFrame(firstRoll, secondRoll);
        String playerName = firstRoll.getPlayerName();
        if(!this.scores.containsKey(playerName)){
            ScoreLine scoreLine = new ScoreLine();
            scoreLine.addFrame(frame);
            this.scores.put(playerName, scoreLine);
        }else{
            this.scores.get(playerName).addFrame(frame);
        }
    }

    @Override
    public void drawResultBoard() {
        this.scores.forEach((k, v) -> {
            System.out.println(k);
            this.drawResultLine(v);
        });
    }

    private void drawResultLine(ScoreLine scoreLine){
        int total = 0;
        System.out.print("Pinfalls\t");
        for (int i =0; i< MAX_PINS + 1; i++){
            System.out.print(scoreLine.getFrame(i).getFrameResult() + "\t");
        }
        System.out.println("");
        System.out.print("Score\t\t");
        for (int i =0; i< MAX_PINS; i++){
            total += scoreLine.getFrame(i).calculate() + this.getBonusScore(i, scoreLine);
            System.out.print(total + "\t\t");
        }
        System.out.println("");
    }


    private int getBonusScore(int currentIndex, ScoreLine scoreLine){
        Frame frame = scoreLine.getFrame(currentIndex);
        if (frame.isSpare()){
            return this.getSpareBonus(currentIndex, scoreLine);
        }

        if (frame.isStrike()){
            return this.getStrikeBonus(currentIndex, scoreLine);
        }

        return 0;
    }

    private int getSpareBonus(int currentIndex, ScoreLine scoreLine){
        return scoreLine.getFrame(currentIndex + 1).getFirstRoll().getNumberOfPins();
    }

    private int getStrikeBonus(int currentIndex, ScoreLine scoreLine){
        Frame nextFrame = scoreLine.getFrame(currentIndex + 1);
        if (nextFrame.isStrike()){
            return nextFrame.getFirstRoll().getNumberOfPins() + scoreLine.getFrame(currentIndex + 2).getFirstRoll().getNumberOfPins();
        }
        return nextFrame.calculate();
    }
}
