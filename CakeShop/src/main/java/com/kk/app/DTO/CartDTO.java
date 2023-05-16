package com.kk.app.DTO;

public class CartDTO {
	
private int id;	
private	String cakename;
private double Price;
private int Quantity;
private String cartcount;
private double addtotal;

public CartDTO(int id, String cakename, double price, int quantity) 
{
	this.id = id;
	this.cakename = cakename;
	Price = price;
	Quantity = quantity;
}

public CartDTO()
{
	
}



public double getAddtotal() {
	return addtotal;
}

public void setAddtotal(double addtotal) {
	this.addtotal = addtotal;
}

public String getCartcount() {
	return cartcount;
}

public void setCartcount(String cartcount) {
	this.cartcount = cartcount;
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
