package com.patrick.SystemPackage;

public class MainApplication {

	public static void main(String[] args) {
		
		Admin patrick = new Admin("patrick","1234");
		patrick.login("Admin");
		User donatien = new Acountant("donald", "6789");
		donatien.methodeTest();
		patrick.addUser(donatien);
	}

}
