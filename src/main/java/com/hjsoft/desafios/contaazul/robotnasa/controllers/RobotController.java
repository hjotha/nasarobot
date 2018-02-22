package com.hjsoft.desafios.contaazul.robotnasa.controllers;

import com.hjsoft.desafios.contaazul.robotnasa.model.MarsRobot;
import com.hjsoft.desafios.contaazul.robotnasa.model.MarsTerrain;
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
