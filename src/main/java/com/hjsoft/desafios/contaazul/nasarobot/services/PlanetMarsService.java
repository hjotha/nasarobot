package com.hjsoft.desafios.contaazul.nasarobot.services;

import com.hjsoft.desafios.contaazul.nasarobot.enums.Directions;
import com.hjsoft.desafios.contaazul.nasarobot.exceptions.InvalidPositionException;
import org.springframework.stereotype.Service;
import com.hjsoft.desafios.contaazul.nasarobot.interfaces.PlanetService;

@Service
public class PlanetMarsService implements PlanetService {

    private static final int MAX_WIDTH = 5;
    private static final int MAX_HEIGHT = 5;

    // init robot's planet position with the default
    private int robotPositionX = 0, robotPositionY = 0;

    public void putRobot(int x, int y) throws InvalidPositionException
    {
        setRobotPositionX( x );
        setRobotPositionY( y );
    }

    public int getRobotPositionX() {
        return robotPositionX;
    }

    public int getRobotPositionY() {
        return robotPositionY;
    }

    private void setRobotPositionX(int x) throws InvalidPositionException
    {
        if( x < 0 || x >= MAX_WIDTH )
            throw new InvalidPositionException();

        this.robotPositionX = x;
    }

    private void setRobotPositionY(int y) throws InvalidPositionException
    {
        if( y < 0 || y >= MAX_HEIGHT )
            throw new InvalidPositionException();

        this.robotPositionY = y;
    }
}
