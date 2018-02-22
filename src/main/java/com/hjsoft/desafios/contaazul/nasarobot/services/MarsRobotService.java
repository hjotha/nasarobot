package com.hjsoft.desafios.contaazul.nasarobot.services;

import com.hjsoft.desafios.contaazul.nasarobot.enums.Directions;
import com.hjsoft.desafios.contaazul.nasarobot.exceptions.InvalidCommandException;
import com.hjsoft.desafios.contaazul.nasarobot.exceptions.InvalidPositionException;
import com.hjsoft.desafios.contaazul.nasarobot.interfaces.PlanetService;
import com.hjsoft.desafios.contaazul.nasarobot.interfaces.RobotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MarsRobotService implements RobotService {

    // init robot with the default facing
    private Directions facing = Directions.NORTH;

    @Autowired
    PlanetService planetService;

    @Override
    public String getPosition() {
        return String.format("(%s, %s, %.1s)\n", planetService.getRobotPositionX(),
                planetService.getRobotPositionY(), facing.toString());
    }

    @Override
    public void sendCommand(String command) throws InvalidCommandException, InvalidPositionException {
        // validate null/empty parameters
        if (command == null || command.isEmpty())
            throw new InvalidCommandException();

        // Set initial robot position and facing 0 0 N
        setFacing(Directions.NORTH);
        planetService.putRobot(0, 0);

        // process command
        for (char c : command.toCharArray()) {
            switch (c) {
                case 'L':
                    setFacing(getFacing().prev());
                    break;
                case 'R':
                    setFacing(getFacing().next());
                    break;
                case 'M':
                    moveRobot(getFacing());
                    break;
                default:
                    throw new InvalidCommandException();
            }
        }
    }

    private void moveRobot(Directions facing) throws InvalidPositionException {

        int robotX = planetService.getRobotPositionX();
        int robotY = planetService.getRobotPositionY();

        switch (facing) {
            case NORTH:
                robotY++;
                break;
            case EAST:
                robotX++;
                break;
            case SOUTH:
                robotY--;
                break;
            case WEST:
                robotX--;
                break;
        }

        planetService.putRobot(robotX, robotY);
    }

    private Directions getFacing() {
        return facing;
    }

    private void setFacing(Directions facing) {
        this.facing = facing;
    }
}
