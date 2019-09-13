package com.example.bowling.Score;

import com.example.bowling.Roll.Roll;

public interface ScoreBuilder {

    void addScore(Roll firstRoll, Roll secondRoll) throws Exception;

    void drawResultBoard();
}
