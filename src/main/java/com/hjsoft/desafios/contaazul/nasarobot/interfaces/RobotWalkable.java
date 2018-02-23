/**
 * This interface defines some walkable land for a robot
 *
 * @author hjotha
 * @since 1.0
 */
package com.hjsoft.desafios.contaazul.nasarobot.interfaces;

import com.hjsoft.desafios.contaazul.nasarobot.exceptions.InvalidPositionException;

/**
 * Implementing this interface allows a robot to walk on something.
 *
 * @see RobotService
 */
public interface RobotWalkable {

    /**
     * The x and y position of the robot on the planet.
     *
     * @param x position
     * @param y position
     * @throws InvalidPositionException if x or y are outside the bounds of the planet.
     */
    void putRobot(int x, int y) throws InvalidPositionException;

    /**
     * The robot's X position on the Planet
     *
     * @return X
     */
    int getRobotPositionX();

    /**
     * The robot's Y position on the Planet
     *
     * @return Y
     */
    int getRobotPositionY();
}
