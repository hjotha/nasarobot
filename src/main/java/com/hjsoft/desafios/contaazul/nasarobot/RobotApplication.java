/**
 * This is the main entrypoint for the robot backend.
 *
 * @author hjotha
 */
package com.hjsoft.desafios.contaazul.nasarobot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Entrypoint
 */
@SpringBootApplication
public class RobotApplication {

    public static void main(String[] args) {
        SpringApplication.run(RobotApplication.class, args);
    }

}