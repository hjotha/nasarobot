package com.hjsoft.desafios.contaazul.nasarobot.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Invalid position")
public class InvalidPositionException extends RuntimeException {
}
