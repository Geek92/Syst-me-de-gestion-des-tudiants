package com.patrick.SystemPackage;

public class MainApplication {

	public static void main(String[] args) {
		
		Admin patrick = new Admin("patrick","1234");
		patrick.login("Admin");
		//User donatien = new Acountant("donald", "6789");
		User max = new Acountant("max", "maria");
		//donatien.methodeTest();
		//patrick.addUser(max);
		//patrick.removeUser(String.valueOf(2));
		
		patrick.EditUserInfo(String.valueOf(5), "name", "tonton");
		patrick.viewUserInfo(String.valueOf(5));
	}

}
