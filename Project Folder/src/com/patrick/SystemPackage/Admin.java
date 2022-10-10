package com.patrick.SystemPackage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Admin extends User {

	DbConnection connection;
	Connection conn; 
	
	public Admin() {
		super();
	}
	
	public Admin(String name, String password) {
		super();
		userName = name;
		this.password = password;
	}

	@Override
	public void addUser(User user) {
		
		if(!(user instanceof Acountant)) {
			
			System.out.println("impossible d'ajouter un utilisateur qui n'est pas un comptable!");
			
		}
		
		StringBuilder builder = new StringBuilder("insert into Accountant (name, password,country,birthDate)");
		builder.append(" values (\"");
		builder.append(user.userName+"\",\"");
		builder.append(user.password+"\",");
		builder.append("\"canada\",");
		builder.append("\"2010-11-12\"");
		builder.append(");");
		
		connection = new DbConnection();
		conn = connection.connect();
		
		String query = builder.toString();
		System.out.println("query: "+query);
		
		try {
			Statement statem = conn.createStatement();
			boolean res = statem.execute(query);
			System.out.println("result: "+res);
			
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void EditUserInfo(String Userid, String value) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeUser(String Userid) {
		// TODO Auto-generated method stub

	}

	@Override
	public void viewUserInfo(String Userid) {
		// TODO Auto-generated method stub

	}

}
