package com.hjsoft.desafios.contaazul.nasa-robot.controllers;

import com.hjsoft.desafios.contaazul.nasa-robot.model.MarsRobot;
import com.hjsoft.desafios.contaazul.nasa-robot.model.MarsTerrain;
import org.springframework.web.bind.annotation.*;

/**
 * Created on 1/11/2018.
 */
@RestController
public class RobotController {

	@RequestMapping(value="/rest/mars/{commands}", method = RequestMethod.GET)
	public @ResponseBody String manage(@PathVariable String commands) {

        MarsRobot robot = new MarsRobot();
	    MarsTerrain mars = new MarsTerrain();

	    robot.setTerrain( mars );
	    robot.sendCommand( commands );

		return robot.getPosition();
	}
}
