/**
 * This service file contains the implementation for the robot
 * facing and movement logic.
 *
 * @author hjotha
 */
package com.hjsoft.desafios.contaazul.nasarobot.services;

import com.hjsoft.desafios.contaazul.nasarobot.enums.Directions;
import com.hjsoft.desafios.contaazul.nasarobot.exceptions.InvalidCommandException;
import com.hjsoft.desafios.contaazul.nasarobot.exceptions.InvalidPositionException;
import com.hjsoft.desafios.contaazul.nasarobot.interfaces.RobotService;
import com.hjsoft.desafios.contaazul.nasarobot.model.Planet;
import com.hjsoft.desafios.contaazul.nasarobot.model.Robot;
import org.springframework.stereotype.Service;

/**
 * Robot facing and movement logic
 */
@Service
public class RobotServiceImpl implements RobotService {

    /**
     * max width of mars
     */
    private static final int MARS_MAX_WIDTH = 5;

    /**
     * max height of mars
     */
    private static final int MARS_MAX_HEIGHT = 5;

    /**
     * The mars Planet
     */
    private Planet mars = new Planet(MARS_MAX_WIDTH, MARS_MAX_HEIGHT);

    /**
     * The robot
     */
    private Robot robot = new Robot(mars);

    /**
     * Construction
     */
    public RobotServiceImpl() {
        robot.setPlanet(mars);
    }

    /**
     * This method returns the position for the robot.
     *
     * @return Robot position in the format: (x,y,Facing)
     */
    @Override
    public String getPosition() {
        return String.format("(%s, %s, %.1s)\n", robot.getPlanet().getRobotPositionX(),
                                                 robot.getPlanet().getRobotPositionY(), robot.getFacing().toString());
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
        robot.setFacing(Directions.NORTH);
        robot.getPlanet().putRobot(0, 0);

        // process command
        for (char c : command.toCharArray()) {
            Directions facing = robot.getFacing();
            switch (c) {
                case 'L': // left
                    robot.setFacing(facing.prev());
                    break;
                case 'R': // right
                    robot.setFacing(facing.next());
                    break;
                case 'M': // move
                    moveRobot(facing);
                    break;
                default: // err
                    throw new InvalidCommandException("Invalid character: " + c);
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
        int robotX = robot.getPlanet().getRobotPositionX();
        int robotY = robot.getPlanet().getRobotPositionY();

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
        robot.getPlanet().putRobot(robotX, robotY);
    }
}
