/**
 * This service file contains the implementation for the planet
 * limits and robot position.
 *
 * @author hjotha
 *
 */
package com.hjsoft.desafios.contaazul.nasarobot.services;

import com.hjsoft.desafios.contaazul.nasarobot.exceptions.InvalidPositionException;
import com.hjsoft.desafios.contaazul.nasarobot.interfaces.PlanetService;
import org.springframework.stereotype.Service;

/**
 * Define Mars a not so desolate 5x5 planet.
 */
@Service
public class PlanetMarsService implements PlanetService {

    // max width of planet
    private static final int MAX_WIDTH = 5;

    // max height of planet
    private static final int MAX_HEIGHT = 5;

    // init robot's planet position with the default
    private int robotPositionX = 0, robotPositionY = 0;

    /**
     * This method puts a robot in some determined position on the planet.
     *
     * @param x position
     * @param y position
     *
     * @throws InvalidPositionException Robot position outside bounds.
     */
    public void putRobot(int x, int y) throws InvalidPositionException {
        setRobotPositionX(x);
        setRobotPositionY(y);
    }

    /**
     * Gets robot X position.
     *
     * @return x position
     */
    public int getRobotPositionX() {
        return robotPositionX;
    }

    /**
     * Gets robot Y position.
     *
     * @return y position
     */
    public int getRobotPositionY() {
        return robotPositionY;
    }

    /**
     * This method sets the X position for the robot, validating bounds.
     * @param x position
     * @throws InvalidPositionException invalid X position.
     */
    private void setRobotPositionX(int x) throws InvalidPositionException {
        if (x < 0 || x >= MAX_WIDTH)
            throw new InvalidPositionException("Invalid X axis movement for robot.");

        this.robotPositionX = x;
    }

    /**
     * This method sets the Y position for the robot, validating bounds.
     * @param y position
     * @throws InvalidPositionException invalid Y position.
     */
    private void setRobotPositionY(int y) throws InvalidPositionException {
        if (y < 0 || y >= MAX_HEIGHT)
            throw new InvalidPositionException("Invalid Y axis movement for robot.");

        this.robotPositionY = y;
    }
}
