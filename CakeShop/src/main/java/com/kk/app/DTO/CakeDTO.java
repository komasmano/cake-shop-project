package com.kk.app.DTO;

public class CakeDTO {
	
private int id;	
private	String cakename;
private double Price;
private int Quantity;

public CakeDTO(int id, String cakename, double price, int quantity) 
{
	this.id = id;
	this.cakename = cakename;
	Price = price;
	Quantity = quantity;
}

public CakeDTO()
{
	
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getCakename() {
	return cakename;
}

public void setCakename(String cakename) {
	this.cakename = cakename;
}

public double getPrice() {
	return Price;
}

public void setPrice(double price) {
	Price = price;
}

public int getQuantity() {
	return Quantity;
}

public void setQuantity(int quantity) {
	Quantity = quantity;
}



}
