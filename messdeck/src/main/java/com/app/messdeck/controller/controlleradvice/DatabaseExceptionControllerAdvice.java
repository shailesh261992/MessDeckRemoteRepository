package com.app.messdeck.controller.controlleradvice;

import javax.servlet.http.HttpServletRequest;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.app.messdeck.controller.exceptions.ErrorInfo;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

@ControllerAdvice
public class DatabaseExceptionControllerAdvice {

	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler({ DataIntegrityViolationException.class })
	public @ResponseBody ErrorInfo handleDatabseExceptions(HttpServletRequest req,
			DataIntegrityViolationException exception) {

		if (exception.getMostSpecificCause() instanceof MySQLIntegrityConstraintViolationException) {
			return new ErrorInfo(req.getRequestURL().toString(),
					((MySQLIntegrityConstraintViolationException) exception.getMostSpecificCause())
							.getLocalizedMessage());

		}
  
		
		return new ErrorInfo(req.getRequestURL().toString(), exception.getMessage());
     
	}

}