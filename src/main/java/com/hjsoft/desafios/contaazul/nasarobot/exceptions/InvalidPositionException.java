/**
 * This custom exception handler defines the specific HTTP status code when
 * the robot tries to move outside the planet.
 *
 * @author hjotha
 */
package com.hjsoft.desafios.contaazul.nasarobot.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InvalidPositionException extends RuntimeException {
    public InvalidPositionException(String message) {
        super(message);
    }
}
