package com.app.messdeck.controller.controlleradvice;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.app.messdeck.businessException.ValidationException;
import com.app.messdeck.businessException.VendorNotExistException;
import com.app.messdeck.controller.exceptions.ErrorInfo;
import com.app.messdeck.model.dto.ValidationErrrorInfo;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

@ControllerAdvice
public class DatabaseExceptionControllerAdvice {

	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler({ DataIntegrityViolationException.class, })
	public @ResponseBody ErrorInfo handleDatabseExceptions(HttpServletRequest req,
			DataIntegrityViolationException exception) {
		System.out.println("*** below is handled Exception");
		exception.printStackTrace();
		if (exception.getMostSpecificCause() instanceof MySQLIntegrityConstraintViolationException) {
			return new ErrorInfo(req.getRequestURL().toString(),
					((MySQLIntegrityConstraintViolationException) exception.getMostSpecificCause())
							.getLocalizedMessage());

		}

		return new ErrorInfo(req.getRequestURL().toString(), exception.getMessage());

	}

	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler({ VendorNotExistException.class })
	public @ResponseBody ErrorInfo handleVendorNotExistException(HttpServletRequest req,
			VendorNotExistException exception) {
         
		return new ErrorInfo(req.getRequestURL().toString(), exception.getMessage());

	}

	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler({ ValidationException.class, })
	public @ResponseBody List<ValidationErrrorInfo> handleValidationExceptions(HttpServletRequest req,
			ValidationException exception) {
		//exception.printStackTrace();

		return exception.getViolationList();

	}
}
