package com.example.bowling;

import com.example.bowling.Frames.Frame;
import com.example.bowling.Frames.FrameCreator;
import com.example.bowling.Roll.Roll;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class FileBowlingGame implements Game{

    private FileParser<Roll> rollParser;
    private Map<String, ScoreLine> scores;
    private FrameCreator frameFactory;

    public FileBowlingGame(FileParser<Roll> rollParser, FrameCreator frameFactory){
        this.rollParser = rollParser;
        this.scores = new HashMap<>();
        this.frameFactory = frameFactory;
    }

    @Override
    public void start(String fileName) {
        try {
            List<Roll> rolls = this.rollParser.getAllData(fileName)
                    .collect(Collectors.toList());
            for (int i = 0; i< rolls.size() - 1; i++){
                this.buildFrame(rolls.get(i), rolls.get(i+1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void buildFrame(Roll firstRoll, Roll secondRoll) throws Exception {
        if (!firstRoll.getPlayerName().equals(secondRoll.getPlayerName()) && firstRoll.getNumberOfPins() != 10){
            return;
        }
        Frame frame =  this.frameFactory.createFrame(firstRoll, secondRoll);
        this.addScore(firstRoll.getPlayerName(), frame);
    }

    private void addScore(String playerName, Frame frame) throws Exception {
        if(!this.scores.containsKey(playerName)){
            ScoreLine scoreLine = new ScoreLine();
            scoreLine.addFrame(frame);
            this.scores.put(playerName, scoreLine);
        }else{
            this.scores.get(playerName).addFrame(frame);
        }
    }

    @Override
    public void displayResults() {
        scores.forEach((k, v) -> v.calculate());
        System.out.println("Results");
    }
}
