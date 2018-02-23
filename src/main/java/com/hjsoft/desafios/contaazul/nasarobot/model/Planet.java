/**
 * This bean defines the attributes for a Planet.
 *
 * @author hjotha
 */
package com.hjsoft.desafios.contaazul.nasarobot.model;

import com.hjsoft.desafios.contaazul.nasarobot.exceptions.InvalidPositionException;
import com.hjsoft.desafios.contaazul.nasarobot.interfaces.RobotWalkable;

/**
 * Defines a simple Planet
 */
public class Planet implements RobotWalkable {

    /**
     * Planet's width
     */
    private int width;

    /**
     * Planet's height
     */
    private int height;

    /**
     * RobotWalkable interface impl
     */
    // init robot's planet position with the default
    private int robotPositionX = 0, robotPositionY = 0;

    /**
     * Constructor that defines planet size.
     *
     * @param width the width of the planet
     * @param height the height of the planet
     */
    public Planet(int width, int height) {
        setWidth(width);
        setHeight(height);
    }

    /**
     * Gets the planet width
     *
     * @return the width
     */
    public int getWidth() {
        return width;
    }

    /**
     * Sets the planet width
     *
     * @param width the width
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * Gets the planet Height
     *
     * @return the height
     */
    public int getHeight() {
        return height;
    }

    /**
     * Sets the planet Height
     *
     * @param height the height
     */
    public void setHeight(int height) {
        this.height = height;
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
     * This method sets the X position for the robot, validating bounds.
     * @param x position
     * @throws InvalidPositionException invalid X position.
     */
    private void setRobotPositionX(int x) throws InvalidPositionException {
        if (x < 0 || x >= getWidth())
            throw new InvalidPositionException("Invalid X axis movement for robot.");

        this.robotPositionX = x;
    }

    /**
     * This method sets the Y position for the robot, validating bounds.
     * @param y position
     * @throws InvalidPositionException invalid Y position.
     */
    private void setRobotPositionY(int y) throws InvalidPositionException {
        if (y < 0 || y >= getHeight())
            throw new InvalidPositionException("Invalid Y axis movement for robot.");

        this.robotPositionY = y;
    }
}
