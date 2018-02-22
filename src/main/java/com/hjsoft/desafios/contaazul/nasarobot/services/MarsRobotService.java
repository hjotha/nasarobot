/**
 * This service file contains the implementation for the robot
 * facing and movement logic.
 *
 * @author hjotha
 *
 */
package com.hjsoft.desafios.contaazul.nasarobot.services;

import com.hjsoft.desafios.contaazul.nasarobot.enums.Directions;
import com.hjsoft.desafios.contaazul.nasarobot.exceptions.InvalidCommandException;
import com.hjsoft.desafios.contaazul.nasarobot.exceptions.InvalidPositionException;
import com.hjsoft.desafios.contaazul.nasarobot.interfaces.PlanetService;
import com.hjsoft.desafios.contaazul.nasarobot.interfaces.RobotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Robot facing and movement logic
 */
@Service
public class MarsRobotService implements RobotService {

    // init robot with the default facing
    private Directions facing = Directions.NORTH;

    // dependency auto-injected
    @Autowired
    PlanetService planetService;

    /**
     * This method returns the position for the robot.
     *
     * @return Robot position in the format: (x,y,Facing)
     */
    @Override
    public String getPosition() {
        return String.format("(%s, %s, %.1s)\n", planetService.getRobotPositionX(),
                                                 planetService.getRobotPositionY(), facing.toString());
    }

    /**
     * This method make the robot execute commands.
     *
     * @param command The string with the commands
     *
     * @throws InvalidCommandException Invalid command string.
     * @throws InvalidPositionException Robot is moving outside bounds.
     */
    @Override
    public void executeCommand(String command) throws InvalidCommandException, InvalidPositionException {
        // validate null/empty parameters
        if (command == null || command.isEmpty())
            throw new InvalidCommandException("Null or empty command string.");

        // Set initial robot position and facing 0 0 N
        setFacing(Directions.NORTH);
        planetService.putRobot(0, 0);

        // process command
        for (char c : command.toCharArray()) {
            Directions facing = getFacing();
            switch (c) {
                case 'L': // left
                    setFacing(facing.prev());
                    break;
                case 'R': // right
                    setFacing(facing.next());
                    break;
                case 'M': // move
                    moveRobot(facing);
                    break;
                default: // err
                    throw new InvalidCommandException("Invalid character: "+c);
            }
        }
    }

    /**
     * This method moves the robot through the planet.
     *
     * @param facing the current robot facing
     * @throws InvalidPositionException Robot is moving outside bounds.
     */
    private void moveRobot(Directions facing) throws InvalidPositionException {

        // gets robot X and Y
        int robotX = planetService.getRobotPositionX();
        int robotY = planetService.getRobotPositionY();

        // according to current robot facing set positions
        switch (facing) {
            case NORTH:
                robotY++; // up
                break;
            case EAST:
                robotX++; // right
                break;
            case SOUTH:
                robotY--; // down
                break;
            case WEST:
                robotX--; // left
                break;
        }

        // move robot
        planetService.putRobot(robotX, robotY);
    }

    /**
     *  Gets the current facing.
     *
     * @return enum with current facing.
     */
    private Directions getFacing() {
        return facing;
    }

    /**
     * Sets the current facing.
     *
     * @param facing enum with facing.
     */
    private void setFacing(Directions facing) {
        this.facing = facing;
    }
}
