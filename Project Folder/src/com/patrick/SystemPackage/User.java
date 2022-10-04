package com.patrick.SystemPackage;

import java.util.Date;

public abstract class User {

	protected int userId;
	protected String userName;
	protected Date userBirthDate;
	protected String Country;
	protected String passsword;
	
	public abstract void login(String userName, String password);
	public abstract void addUser(User user);
	public abstract void EditUserInfo(String Userid, String value);
	public abstract void removeUser(String Userid);
	public abstract void viewUserInfo(String Userid);
	
	
	
	
	
}
