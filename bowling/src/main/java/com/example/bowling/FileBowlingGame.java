package com.example.bowling;

import com.example.bowling.Roll.Roll;
import com.example.bowling.Score.ScoreBuilder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FileBowlingGame implements Game{

    private FileParser<Roll> rollParser;
    ScoreBuilder scorer;
    static final int MAX_PINS = 10;

    public FileBowlingGame(FileParser<Roll> rollParser, ScoreBuilder scorer){
        this.rollParser = rollParser;
        this.scorer = scorer;
    }

    @Override
    public void start(String fileName) {
        try {
            List<Roll> rolls = this.rollParser.getAllData(fileName)
                    .collect(Collectors.toList());
            this.rollParser.validateData(rolls);

            for (int i = 0; i< rolls.size() - 1; i++){
                this.addScore(rolls.get(i), rolls.get(i+1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void addScore(Roll firstRoll, Roll secondRoll) throws Exception {
        if (!firstRoll.getPlayerName().equals(secondRoll.getPlayerName()) && firstRoll.getNumberOfPins() != MAX_PINS){
            return;
        }
        this.scorer.addScore(firstRoll, secondRoll);
    }

    @Override
    public void displayResults() {
        System.out.println("Frame       1       2       3       4       5       6       7       8       9       10");
        this.scorer.drawResultBoard();
    }
}
