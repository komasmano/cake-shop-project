package com.kk.app.DTO;

public class Cakeuserdto
{

private String email;
private String password;
private long contactno;
private String name;
public Cakeuserdto(String email, String password, long contactno, String name) {
	super();
	this.email = email;
	this.password = password;
	this.contactno = contactno;
	this.name = name;
}

public Cakeuserdto()
{
	
}


public Cakeuserdto(String email, String password) 
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
