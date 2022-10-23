package com.patrick.SystemPackage.users;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.patrick.SystemPackage.connection.DbConnection;
import com.patrick.SystemPackage.exceptions.AccountantTypeException;
import com.patrick.SystemPackage.exceptions.StudentTypeException;
import com.patrick.SystemPackage.exceptions.UnfoundUserException;

public class Acountant extends User {
	
	DbConnection connection;
	Connection conn;
	public Acountant() {
		
	}
	
	public Acountant(String userName, String password) {
		
		this.userName = userName;
		this.password = password;
	}
	
	@Override
	/**
	 * @param StudentId
	 * @param columnName
	 * @param value
	 * @throws UnfoundUserException
	 */
	public void EditUserInfo(String StudentId, String columnName,String value) throws UnfoundUserException{
		
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
		String query = builder.toString();
		
		connection = new DbConnection();
		 conn = connection.connect();
		 try {
			 	Statement stat = conn.createStatement();
			 	int result = stat.executeUpdate(query);
			 	if(result == 0) {
			 		throwException(StudentId);
			 	} else {
			 		System.out.println("operation effectuee avec succes!");
			 		System.out.println("nombre de lignes affectées: "+result);
			 }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void removeUser(String StudentId) throws UnfoundUserException{
		
		StringBuilder builder = new StringBuilder("delete from Student where id = ");
		builder.append(StudentId);
		builder.append(";");
		String query = builder.toString();
		
		try {
				connection = new DbConnection();
				conn = connection.connect();
				Statement stat = conn.createStatement();
				int result = stat.executeUpdate(query);
				if(result == 0) {
					throwException(StudentId);
				} else {
					System.out.println("l'utilisateur a ete retire de la base de données!");
				}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void viewUserInfo(String Userid) {
		loggedIn();
		StringBuilder builder = new StringBuilder("select * from Student where id = ");
		builder.append(Userid);
		builder.append(";");
		String query = builder.toString();
		connection = new DbConnection();
		conn = connection.connect();
		System.out.println(query);
		try {
				Statement statem = conn.createStatement();
				ResultSet res = statem.executeQuery(query);
				if(!res.isBeforeFirst()) {
					throw new UnfoundUserException("l'utilisateur n'est pas present dans la base de données");
				}else {
					while(res.next()) {
						System.out.println("name: "+res.getString("name"));
						System.out.println("birthDate: "+res.getString("birhDate"));
						System.out.println("email: "+res.getString("email"));
						System.out.println("payedFees: "+res.getString("payedFees"));
						System.out.println("dueFees: "+res.getString("dueFees"));
					}
				}
		}catch(Exception e) {
			e.printStackTrace();
		}
		connection.closeConnection();

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

	@Override
	public void addUseraddUser(User user) throws AccountantTypeException, StudentTypeException, SQLException {
		// TODO Auto-generated method stub
		
	}
	
	public void throwException(String StudentId) throws UnfoundUserException{
 		throw new UnfoundUserException("l'utilisateur avec l'id = "+StudentId+" n'est pas peresent dans la base de données");
	}

}
