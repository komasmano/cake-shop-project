package com.kk.app.DTO;

public class OrderBookDTO 
{
	

	private int id;
	private String cakename;
	private double price;
	private String Quantity;
	private double addamount;
	private double total;
	private String address;
	private String date;
	private String time;
	private int orderno;
	private String username;
	private long contactno;
	
	

	public OrderBookDTO(double total, String address, String date, String time, int orderno, String username,
			long contactno) {
		super();
		this.total = total;
		this.address = address;
		this.date = date;
		this.time = time;
		this.orderno = orderno;
		this.username = username;
		this.contactno = contactno;
	}




	public OrderBookDTO(int id, String cakename, double price, String quantity, double total , int orderno) 
	{
		this.id = id;
		this.cakename = cakename;
		this.price = price;
		this.Quantity = quantity;
		this.total = total;
		this.orderno = orderno;
	}




	public OrderBookDTO(int id, String cakename, int quantity, double total, String address, String date, String time,
			int orderno, String username, long contactno) {
		super();
		this.id = id;
		this.cakename = cakename;
		this.total = total;
		this.address = address;
		this.date = date;
		this.time = time;
		this.orderno = orderno;
		this.username = username;
		this.contactno = contactno;
	}


	public OrderBookDTO()
	{
		
	}


	
	
	
	public double getAddamount() {
		return addamount;
	}





	public void setAddamount(double addamount) {
		this.addamount = addamount;
	}





	public String getQuantity() {
		return Quantity;
	}


	public void setQuantity(String quantity) {
		Quantity = quantity;
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



	public double getTotal() {
		return total;
	}


	public void setTotal(double total) {
		this.total = total;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public String getTime() {
		return time;
	}


	public void setTime(String time) {
		this.time = time;
	}


	public int getOrderno() {
		return orderno;
	}


	public void setOrderno(int orderno) {
		this.orderno = orderno;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public long getContactno() {
		return contactno;
	}


	public void setContactno(long contactno) {
		this.contactno = contactno;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}




}

