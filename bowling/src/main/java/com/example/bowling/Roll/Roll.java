package com.example.bowling.Roll;

import java.util.regex.Pattern;

public class Roll {

    private String numberOfPins;
    private String playerName;

    public Roll(String numberOfPins, String player){
        this.numberOfPins = numberOfPins;
        this.playerName = player;
    }

    public int getNumberOfPins(){
        return !this.numberOfPins.equals("F") ? Integer.parseInt(this.numberOfPins) : 0;
    }

    public String getPlayerName() {
        return playerName;
    }

    void validateRoll() throws Exception{
        boolean isValid = this.numberOfPins.matches("[0-9]|0[1-9]|10|F");
        if (!isValid){
            throw new Exception(this.numberOfPins + " knocked down pins for " + this.playerName + " is incorrect, acceptable numbers are: 0-10 or F for foul");
        }
    }
}