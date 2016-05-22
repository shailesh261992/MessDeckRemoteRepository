package com.app.messdeck.businessException;

import java.util.List;

public class InvalidDateFormatException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidDateFormatException(String format) {
		super("Valid date formats : " + format);
	}

}
