package com.patrick.SystemPackage.users;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.patrick.SystemPackage.connection.DbConnection;
import com.patrick.SystemPackage.exceptions.AccountantTypeException;
import com.patrick.SystemPackage.exceptions.UnfoundUserException;

/**
 * 
 * @author patrickfrank
 *
 */
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
	public void addUseraddUser(User user) throws AccountantTypeException, SQLException{
		loggedIn();
		
		if(!(user instanceof Acountant)) {
			
			throw new AccountantTypeException("l'utilisateur doit etre un comptable!");
			
		} else {
		
			StringBuilder builder = new StringBuilder("insert into Accountant (name, password,country,birthDate)");
			builder.append(" values (\"");
			builder.append(user.userName+"\",\"");
			builder.append(user.password+"\",");
			builder.append("\"canada\",");
			builder.append("\"2010-11-12\"");
			builder.append(");");
			String query = builder.toString();
			
			connection = new DbConnection();
			conn = connection.connect();
			System.out.println("query: "+query);
			Statement statem = conn.createStatement();
			boolean res = statem.execute(query);
			System.out.println("result: "+res);
			connection.closeConnection();
		}
	}

	@Override
	public void EditUserInfo(String Userid, String columnName,String value) throws UnfoundUserException{
		
		loggedIn();
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
			if(res == 0) {
				throw new UnfoundUserException("l'utilisateur avec l'id = "+Userid+" n'est pas present dans la base de données");
			}
			else {
				System.out.println("operation effectuée avec succes!");
				System.out.println("nombre de lignes affectées: "+res);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		connection.closeConnection();
	}
	
	@Override
	public void removeUser(String userId) throws UnfoundUserException{
		
		loggedIn();
		StringBuilder builder = new StringBuilder("delete from Accountant where id = ");
		builder.append(userId);
		builder.append(";");
		String query = builder.toString();
		System.out.println(query);
		connection = new DbConnection();
		conn = connection.connect();
		try {
				Statement statem = conn.createStatement();
				int res = statem.executeUpdate(query);
				System.out.println("result: "+res);
				if(res == 0){
					throw new UnfoundUserException("cet utilisateur n'est pas present dans la base de données");
				}else{
					System.out.println("l\'utilsateur a bien ete supprime de la base de donnees.");
				}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		connection.closeConnection();
	}

	@Override
	public void viewUserInfo(String userId) {
		
		loggedIn();
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
		}catch(Exception e) {
			e.printStackTrace();
		}
		connection.closeConnection();
	}
	
	public void loggedIn() {
		if(!isUserLoggedIn                                                                                                                                                ) {
			System.out.println("vous devez effectuer le loggin avant de pouvoir executer cette operation!");
			System.exit(-1);
		}
	}
}
