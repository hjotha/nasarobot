package com.hjsoft.desafios.contaazul.nasarobot.controllers;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.hjsoft.desafios.contaazul.nasarobot.interfaces.RobotService;

/**
 * Created on 1/11/2018.
 */
@RestController
public class RobotController {

	@Autowired
    private RobotService robotService;

	@RequestMapping(value="/rest/mars/{commands}")
	public @ResponseBody String manage(@PathVariable String commands) {

		robotService.sendCommand( commands );

		return robotService.getPosition();
	}
}
