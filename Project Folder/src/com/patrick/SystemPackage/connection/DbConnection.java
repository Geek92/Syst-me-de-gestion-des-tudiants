package com.patrick.SystemPackage.connection;

import java.sql.*;

/**
 * 
 * @author patrickfrank
 *  Classe qui permets de gerer la connection a la base de données
 */

public class DbConnection {
	
	Connection conn = null;
	String url = "jdbc:mysql://localhost:3306/";
	String dbName = "fees_management";
	String driver = "com.mysql.cj.jdbc.Driver";
	String userName = "root";
	String password = "";

	//methode qui permet de se connecter a la base de donnee
	 public Connection connect(){
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
	  public void closeConnection() {
		
		 try {
			conn.close();
			System.out.println("connection fermée avec success");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
