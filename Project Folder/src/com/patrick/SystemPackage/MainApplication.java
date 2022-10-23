package com.patrick.SystemPackage;

import com.patrick.SystemPackage.users.Acountant;
import com.patrick.SystemPackage.users.Admin;
import com.patrick.SystemPackage.users.Student;

public class MainApplication {

	public static void main(String[] args) {
		
		/*Acountant mateo = new Acountant("mateo","maria");
		
		mateo.login("Accountant");
		
		Student patson = new Student("frank");
		
		try {
			mateo.addStudent(patson);
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
		Admin patrick = new Admin("patrick","1234");
		patrick.login("Admin");
		//ajouter um comptable
		
		Acountant mateo = new Acountant("mateo","234567");
		
		Student diane = new Student("Diane");
		
		
		try {
			
			//patrick.addUseraddUser(mateo);
			//patrick.EditUserInfo("10", "country", "Cameroun");
			mateo.login("Accountant");
			//mateo.addStudent(diane);
			//mateo.EditUserInfo("3", "email", "diane@yahoo.com");
			mateo.viewUserInfo("3");
			mateo.removeUser("3");
			mateo.viewUserInfo("3");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		// voir les informations relatives a un comptable
		
		//patrick.viewUserInfo("10");
		
		
		//patrick.viewUserInfo("9");
		
		//patrick.removeUser("9");
	}

}
