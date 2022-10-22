package com.patrick.SystemPackage.users;

import java.sql.SQLException;
import java.sql.Statement;

import com.patrick.SystemPackage.connection.DbConnection;
import com.patrick.SystemPackage.exceptions.AccountantTypeException;
import com.patrick.SystemPackage.exceptions.StudentTypeException;

public class Acountant extends User {
	
	DbConnection connection;
	public Acountant() {
		
	}
	
	public Acountant(String userName, String password) {
		
		this.userName = userName;
		this.password = password;
	}
	
	/**
	 * @param user 
	 * cette methode permets d'ajouter des utilisateurs de type comptable dans la base de donnees
	 */
	@Override
	public void addUseraddUser(User user) {
		
	}

	@Override
	public void EditUserInfo(String StudentId, String columnName,String value) {
		
		loggedIn();
		
		StringBuilder builder = new StringBuilder("update Student set "+columnName+" = ");
		
		switch(columnName) {
		case "email":
		case "studentName":
			builder.append("\'"+value+"\'");
			break;
		default:
			builder.append(value);
		}
		builder.append(" where id = "+StudentId+";");
	}

	@Override
	public void removeUser(String Userid) {
		// TODO Auto-generated method stub

	}

	@Override
	public void viewUserInfo(String Userid) {
		// TODO Auto-generated method stub

	}
	public void loggedIn() {
		if(!isUserLoggedIn) {
			System.out.println("vous devez etre connecte pour pouvoir effectuer cette operation!");
			System.exit(-1);
		}
	}
	
	public void addStudent(Student student) throws StudentTypeException,SQLException{
		loggedIn();
		if(!(student instanceof Student)) {
			throw new StudentTypeException();
		}
		connection = new DbConnection();
		conn = connection.connect();
		StringBuilder builder = new StringBuilder("insert into Student (birhDate,dueFees,email,name,payedFees) values(");
		builder.append("\'2010-11-12\',");
		builder.append("1300.00,");
		builder.append("\'patson@yahoo.fr\',");
		builder.append("\'"+student.studentName+"\',");
		builder.append("600.00);");
		String query = builder.toString();
		System.out.println("query: "+query);
		Statement stat = conn.createStatement();
		int result = stat.executeUpdate(query);
		System.out.println("result: "+result);
		connection.closeConnection();
	}

}
