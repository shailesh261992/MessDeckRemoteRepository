package com.app.messdeck.businessException;

public class MessDeckServiceNotExistException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MessDeckServiceNotExistException(long id) {
		super("MessDeckService with id = " + id + " Not exists");
	}

}
