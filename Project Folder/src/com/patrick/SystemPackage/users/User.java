package com.patrick.SystemPackage.users;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import com.patrick.SystemPackage.connection.DbConnection;
import com.patrick.SystemPackage.exceptions.AccountantTypeException;
import com.patrick.SystemPackage.exceptions.StudentTypeException;

public abstract class User {

	protected int userId;
	protected String userName;
	protected Date userBirthDate;
	protected String Country;
	protected String password;
	Connection conn;
	protected Boolean isUserLoggedIn = false;
	
	//public abstract boolean login();
	public abstract void addUseraddUser(User user) throws AccountantTypeException,StudentTypeException,SQLException;
	public abstract void EditUserInfo(String Userid, String columnName,String value);
	public abstract void removeUser(String Userid);
	public abstract void viewUserInfo(String Userid);
	
	
	public void login(String tableau) {
		
		DbConnection connection = new DbConnection();
		conn = connection.connect();
		String resultName = "";
		String resultPassword = "";
		StringBuilder builder = new StringBuilder("select * from "+tableau+ " where name = \'");
		builder.append(userName);
		builder.append("\'");
		builder.append(" and password = \'");
		builder.append(password);
		builder.append("\'");
		builder.append(";");
		String query = builder.toString();
		System.out.println(query);
		try {
				Statement statem = conn.createStatement();
				ResultSet res = statem.executeQuery(query);
				while(res.next()) {
					resultName = res.getString("name");
					resultPassword = res.getString("password");
					//System.out.println("result: "+result);
				}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(resultName.equals(userName) && resultPassword.equals(password)){
			System.out.println("login effectue avec succes");
			System.out.println("bienvenue " + resultName);
			isUserLoggedIn = true;
		} else {
			System.out.println("username ou mot de passe incorrect");
		}
	}

	
	protected void methodeTest() {
		System.out.println("test pur les methodes private");
	}
	
	
	
}
