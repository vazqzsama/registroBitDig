package com.portal.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.google.gson.Gson;
import com.portal.app.api.ApiError;

//@ControllerAdvice
public class CustomRestExceptionHandler {

	private static final Logger log = LoggerFactory.getLogger(CustomRestExceptionHandler.class);
	
    /*@ExceptionHandler({ Exception.class })
    public ResponseEntity<Object> handleAll(final Exception ex, final WebRequest request) {
        String error = ex.getClass().getName(); 
        HttpStatus httpSts = HttpStatus.INTERNAL_SERVER_ERROR;
        switch (ex.getClass().getName()) {
			case "java.lang.NullPointerException" :
			case "java.lang.IllegalArgumentException" :
					httpSts = HttpStatus.BAD_REQUEST;
			break;
			case "javax.validation.ConstraintDeclarationException" :
				httpSts = HttpStatus.PRECONDITION_FAILED;
			break;
			case "org.springframework.http.converter.HttpMessageNotReadableException" :
				httpSts = HttpStatus.BAD_REQUEST;
			break;
		}
        
        final ApiError apiError = new ApiError(httpSts, ex.getLocalizedMessage(), error);
        ResponseEntity<Object> response = new ResponseEntity<Object>(apiError, new HttpHeaders(), apiError.getStatus());
		log.error("ExceptionHandler: "+new Gson().toJson(response));
        return response;
    }*/

}