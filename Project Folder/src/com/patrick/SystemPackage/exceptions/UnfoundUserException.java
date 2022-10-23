package com.patrick.SystemPackage.exceptions;

/**
 * 
 * @author patrickfrank
 * 
 * <p>
 *  cette Exception est soulevée lorqu'on veut effectuer des operations 
 *  sur un utilisateur qui n'est pas present dans la base de données
 * <p/>
 *
 */

public class UnfoundUserException extends Exception {

	public UnfoundUserException(String message) {
		super(message);
	}
	
	public UnfoundUserException() {
		super();
	}
}
