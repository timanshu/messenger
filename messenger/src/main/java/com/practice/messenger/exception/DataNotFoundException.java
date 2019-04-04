package com.practice.messenger.exception;

public class DataNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3804987708469625775L;
	
	public DataNotFoundException(String  message)
	{
		super(message);
	}
}
