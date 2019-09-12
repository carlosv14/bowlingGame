package com.example.bowling.Roll;

import com.example.bowling.Calculable;

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
}