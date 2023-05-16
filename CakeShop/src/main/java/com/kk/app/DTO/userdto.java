package com.kk.app.DTO;

public class userdto
{

private String email;
private String password;
private long contactno;
private String name;

public userdto(String email, String password, long contactno, String name) {
	this.email = email;
	this.password = password;
	this.contactno = contactno;
	this.name = name;
}

public userdto()
{
	
}


public userdto(String email, String password) 
{
	this.email = email;
	this.password = password;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public long getContactno() {
	return contactno;
}

public void setContactno(long contactno) {
	this.contactno = contactno;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}



}
