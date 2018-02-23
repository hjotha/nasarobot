/**
 * This is the main controller for the robot backend app.
 *
 * @author hjotha
 */

package com.hjsoft.desafios.contaazul.nasarobot.controllers;

import com.hjsoft.desafios.contaazul.nasarobot.interfaces.RobotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * This controller manages the robot command execution and position.
 */
@RestController
public class RobotController {

    @Autowired
    private RobotService robotService;

    /**
     * This method executes commands and returns robot position.
     *
     * @param commands command string
     * @return Current position for robot in the format: "(x,y,Facing)"
     */
    //@PostMapping(value = "/rest/mars/{commands}")
    // So we can test in browser too
    @RequestMapping(value = "/rest/mars/{commands}")
    public String manage(@PathVariable String commands) {

        robotService.executeCommand(commands);

        return robotService.getPosition();
    }
}
