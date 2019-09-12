package com.example.bowling;

import com.example.bowling.Frames.Frame;
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

    public FileBowlingGame(FileParser<Roll> rollParser){
        this.rollParser = rollParser;
        this.scores = new HashMap<String, ScoreLine>();
    }

    @Override
    public void start(String fileName) {
        try {
            List<Roll> rolls = this.rollParser.getAllData(fileName)
                    .collect(Collectors.toList());
            for (int i = 0; i< rolls.size() - 1; i++){
                this.buildFrame(rolls.get(i), rolls.get(i+1));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void buildFrame(Roll firstRoll, Roll secondRoll){
        if (firstRoll.getPlayerName().equals(secondRoll.getPlayerName())){

        }
    }

    @Override
    public void displayResults() {
        System.out.println("Results");
    }
}
