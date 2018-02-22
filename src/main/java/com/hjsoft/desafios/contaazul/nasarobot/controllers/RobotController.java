package com.hjsoft.desafios.contaazul.nasarobot.controllers;

import com.hjsoft.desafios.contaazul.nasarobot.interfaces.RobotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created on 1/11/2018.
 */
@RestController
public class RobotController {

    @Autowired
    private RobotService robotService;

    @RequestMapping(value = "/rest/mars/{commands}")
    public @ResponseBody
    String manage(@PathVariable String commands) {

        robotService.sendCommand(commands);

        return robotService.getPosition();
    }
}
