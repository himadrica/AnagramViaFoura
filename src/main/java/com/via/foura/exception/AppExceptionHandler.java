package com.via.foura.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.via.foura.app.response.ErrorResponse;

/**
 * @author himadri
 *
 * This custom exception handler handles the exception generated if the input strings
 * are not a valid string. It returns 400 status code with a json format
 */
@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(AnagramException.class)
	public final ResponseEntity<ErrorResponse> handleBadRequestExceptions(AnagramException ex, WebRequest request) {
		List<String> details = new ArrayList<>();
		details.add(ex.getLocalizedMessage());
		ErrorResponse error = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage(), details);
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

}