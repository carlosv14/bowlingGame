package com.example.bowling.Roll;

public class Roll {

    private String numberOfPins;
    private String playerName;

    public Roll(String numberOfPins, String player){
        this.numberOfPins = numberOfPins;
        this.playerName = player;
    }

    public int getNumberOfPins() {
        return !numberOfPins.equals("F") ? Integer.parseInt(numberOfPins) : 0;
    }

    public String getPlayerName() {
        return playerName;
    }
}