package com.patrick.SystemPackage;

import com.patrick.SystemPackage.users.Acountant;
import com.patrick.SystemPackage.users.Student;

public class MainApplication {

	public static void main(String[] args) {
		
		Acountant mateo = new Acountant("mateo","maria");
		
		mateo.login("Accountant");
		
		Student patson = new Student("frank");
		
		try {
			mateo.addStudent(patson);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
