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
		connection.closeConnection();
	}

	@Override
	public void EditUserInfo(String Userid, String columnName,String value) {
		StringBuilder builder = new StringBuilder("update Accountant set ");
		builder.append(columnName);
		builder.append(" ="+"\'"+value+"\'");
		builder.append(" where id = "+Userid+";");
		String query = builder.toString();
		System.out.println(query);
		
		connection = new DbConnection();
		conn = connection.connect();
		

		try {
			Statement statem = conn.createStatement();
			int res = statem.executeUpdate(query);
			System.out.println("result: "+res);
		} catch(Exception e) {
			e.printStackTrace();
		}
		connection.closeConnection();
	}
	/*
	 * methode qui permets de supprimer un comptable
	 */
	@Override
	public void removeUser(String userId) {
		
		StringBuilder builder = new StringBuilder("delete from Accountant where id = ");
		builder.append(userId);
		builder.append(";");
		String query = builder.toString();
		System.out.println(query);
		try {
			Statement statem = conn.createStatement();
			boolean res = statem.execute(query);
			System.out.println("result: "+res);
			System.out.println("l/'utilsateur a bien ete supprime de la base de donnees.");
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void viewUserInfo(String userId) {
		StringBuilder builder = new StringBuilder("select * from Accountant where id = ");
		builder.append(userId);
		builder.append(";");
		String query = builder.toString();
		connection = new DbConnection();
		conn = connection.connect();
		System.out.println(query);
		try {
			Statement statem = conn.createStatement();
			ResultSet res = statem.executeQuery(query);
			while(res.next()) {
				System.out.println("name: "+res.getString("name"));
				System.out.println("birthDate: "+res.getString("birthDate"));
				System.out.println("country: "+res.getString("country"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		connection.closeConnection();
	}

}
