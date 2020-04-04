package com.via.foura.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

/**
 * @author himadri
 * 
 * custom exception class for BAD_REQUEST
 */
@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class AnagramException extends RuntimeException  {
    private static final long serialVersionUID = 1L;

    public AnagramException(String errorMessage) {
        super(errorMessage);
    }
}