/**
 * This interface defines the relevant methods for a Robot
 * which has a position and can execute commands.
 *
 * @author hjotha
 * @since 1.0
 */
package com.hjsoft.desafios.contaazul.nasarobot.interfaces;

import com.hjsoft.desafios.contaazul.nasarobot.exceptions.InvalidCommandException;
import com.hjsoft.desafios.contaazul.nasarobot.exceptions.InvalidPositionException;

/**
 * Implementing this interface allows a robot to get its position on a planet
 * and execute commands.
 *
 * @see PlanetService
 */
public interface RobotService {

    /**
     * Retrieves an String that representes the position for a Robot
     * with the format: "(x, y, Facing)"
     *
     * @return String with position.
     */
    String getPosition();

    /**
     * Executes a list of commands, the commands can be:
     *
     * L - Move robot facing to left
     * R - Move robot facing to right
     * M - Move robot forward (to the direction of the facing)
     *
     * @param command The string with the commands
     *
     * @throws InvalidCommandException If unknown characters are sent in the string.
     * @throws InvalidPositionException If robot is instructed to move outside bounds.
     */
    void executeCommand(String command) throws InvalidCommandException, InvalidPositionException;
}
