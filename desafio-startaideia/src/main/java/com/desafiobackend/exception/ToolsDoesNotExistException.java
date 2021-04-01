package com.desafiobackend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Tools does not exist")
public class ToolsDoesNotExistException  extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
