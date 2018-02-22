package com.hjsoft.desafios.contaazul.nasa-robot.model;

import com.hjsoft.desafios.contaazul.nasa-robot.exceptions.InvalidCommandException;

public class MarsRobot {

    String position;


    public void setTerrain(MarsTerrain terrain) {
        this.terrain = terrain;
    }

    public void sendCommand(String commands) throws InvalidCommandException {

        if ( commands == null || commands.isEmpty() || (!commands.contains("M") && !commands.contains("L") && !commands.contains("R")) )
            throw new InvalidCommandException();



    }

    public String getPosition() {

        return position;
    }
}