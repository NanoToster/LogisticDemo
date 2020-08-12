package ru.toster.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Ivan Rovenskiy
 * 12 August 2020
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "wrong input params")
public class BadParamsException extends RuntimeException {
    public BadParamsException(String message) {
        super(message);
    }
}
