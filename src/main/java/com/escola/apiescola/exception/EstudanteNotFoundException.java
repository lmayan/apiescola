package com.escola.apiescola.exception;

public class EstudanteNotFoundException extends Exception {

	private static final long serialVersionUID = 307522741859168047L;

	public EstudanteNotFoundException() {
		super();
	}

	public EstudanteNotFoundException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public EstudanteNotFoundException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public EstudanteNotFoundException(String arg0) {
		super(arg0);
	}

	public EstudanteNotFoundException(Throwable arg0) {
		super(arg0);
	}
	
	

}
