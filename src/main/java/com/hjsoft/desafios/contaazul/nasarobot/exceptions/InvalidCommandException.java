/**
 * This custom exception handler defines the specific HTTP status code when
 * there are parsing errors in the command input.
 *
 * @author hjotha
 */
package com.hjsoft.desafios.contaazul.nasarobot.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InvalidCommandException extends RuntimeException {

    public InvalidCommandException(String message) {
        super(message);
    }
}
