package com.patrick.SystemPackage.exceptions;

public class AccountantTypeException extends Exception {

	 private static final long serialVersionUID = 1L;

	public AccountantTypeException(String message) {
		 super(message);
	 }
	
	public AccountantTypeException() {
		super();
	}
}
