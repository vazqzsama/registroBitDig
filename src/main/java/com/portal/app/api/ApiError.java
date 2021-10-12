package com.portal.app.api;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class ApiError {
	public final static String UNEXPECTED_ERROR_MSG = "Error en el servicio";

	private HttpStatus status;
	private String message;
	private List<String> errors;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private LocalDateTime timestamp;
	
	public ApiError() {
        super();
    }
	
	/*public ApiError(HttpStatus badRequest, String string, String error) {
		this(UNEXPECTED_ERROR_MSG);
	}*/

	public ApiError(final String message) {
		this(message, "");
	}

	public ApiError(final String message, final String codigo) {
		this.message = message;
		this.timestamp = LocalDateTime.now();
	}

	public ApiError(final HttpStatus status, final String message, final List<String> errors) {
        super();
        this.status = status;
        this.message = message;
        this.errors = errors;
        this.timestamp = LocalDateTime.now();
    }

    public ApiError(final HttpStatus status, final String message, final String error) {
        super();
        this.status = status;
        this.message = message;
        errors = Arrays.asList(error);
        this.timestamp = LocalDateTime.now();
    }

}
