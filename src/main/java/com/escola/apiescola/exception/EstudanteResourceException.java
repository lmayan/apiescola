package com.escola.apiescola.exception;

public class EstudanteResourceException extends Exception{

	private static final long serialVersionUID = -3323167502962255084L;

	public EstudanteResourceException() {
		super();
	}

	public EstudanteResourceException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public EstudanteResourceException(String message, Throwable cause) {
		super(message, cause);
	}

	public EstudanteResourceException(String message) {
		super(message);
	}

	public EstudanteResourceException(Throwable cause) {
		super(cause);
	}
	
	

}
