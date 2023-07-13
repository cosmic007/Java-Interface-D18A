package com.canddella.entity;

import java.util.ArrayList;

public class Customer {
	
	private String customerID;
	private String customerName;
	private ArrayList <Product> productList;
	public String getCustomerID() {
		return customerID;
	}
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public ArrayList<Product> getProductList() {
		return productList;
	}
	public void setProductList(ArrayList<Product> productList) {
		this.productList = productList;
	}
	public Customer(String customerID, String customerName, ArrayList<Product> productList) {
		super();
		this.customerID = customerID;
		this.customerName = customerName;
		this.productList = productList;
	}
	
	
	
	

}
