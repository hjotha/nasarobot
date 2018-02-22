/**
 * This interface defines the relevant parameters for a Planet
 * which is considered an squared terrain.
 *
 * @author hjotha
 * @since 1.0
 */
package com.hjsoft.desafios.contaazul.nasarobot.interfaces;

import com.hjsoft.desafios.contaazul.nasarobot.enums.Directions;
import com.hjsoft.desafios.contaazul.nasarobot.exceptions.InvalidPositionException;

/**
 * Implementing this interface allows a robot to walk on it.
 * @see RobotService
 */
public interface PlanetService {

    /**
     * The x and y position of the robot on the planet.
     *
     * @param x position
     * @param y position
     *
     * @exception InvalidPositionException if x or y are outside the bounds of the planet.
     */
    void putRobot(int x, int y) throws InvalidPositionException;

    int getRobotPositionX();

    int getRobotPositionY();
}
