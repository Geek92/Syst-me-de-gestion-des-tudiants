package com.patrick.SystemPackage;

import java.sql.*;

public class DbConnection {
	
	Connection conn = null;
	String url = "jdbc:mysql://localhost:3306/";
	String dbName = "fees_management";
	String driver = "com.mysql.cj.jdbc.Driver";
	String userName = "root";
	String password = "";

	//methode qui permet de se connecter a la base de donnee
	 Connection connect(){
		System.out.println("tentative de connection à la base de données");
		
		try {
			
			Class.forName(driver).getDeclaredConstructor().newInstance();
			conn = DriverManager.getConnection(url+dbName,userName,password);
			System.out.println("connection établie avec success");
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}

	 //fermer la connection à la base de données
	  void closeConnection() {
		
		 try {
			conn.close();
			System.out.println("connection fermée avec success");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
