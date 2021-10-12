package com.portal.app;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.portal.app.api.ApiError;

@ControllerAdvice
public class CustomRestExceptionHandler {

    @ExceptionHandler({ Exception.class })
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
        return new ResponseEntity<Object>(apiError, new HttpHeaders(), apiError.getStatus());
    }

}