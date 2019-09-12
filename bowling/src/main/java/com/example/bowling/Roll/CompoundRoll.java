package com.example.bowling.Roll;

import java.util.ArrayList;
import java.util.List;

public class CompoundRoll extends Roll{

    List<Roll> childrenRolls;

    public CompoundRoll(String numberOfPins, String playerName){
        super(numberOfPins, playerName);
        this.childrenRolls = new ArrayList<>();
    }

    public void addRoll(Roll roll){
        this.childrenRolls.add(roll);
    }

    @Override
    public int getNumberOfPins() {
        return this.childrenRolls
                .stream()
                .mapToInt(n -> n.getNumberOfPins())
                .sum();
    }
}
