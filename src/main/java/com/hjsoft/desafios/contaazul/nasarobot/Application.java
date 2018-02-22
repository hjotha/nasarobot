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
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}