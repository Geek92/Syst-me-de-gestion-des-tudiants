package com.patrick.SystemPackage.exceptions;

public class StudentTypeException extends Exception {

	private static final long serialVersionUID = 1L;

	public StudentTypeException() {
		super("l'instance doit etre de type etudiant");
	}
}
