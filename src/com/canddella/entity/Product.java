package com.canddella.entity;

public abstract class Product {
	
	private String productName;
	private String productCode;
	private String productType;
	private double productRate;
	
	
	
	
	
	
	public Product(String productName, String productCode, String productType, double productRate) {
		super();
		this.productName = productName;
		this.productCode = productCode;
		this.productType = productType;
		this.productRate = productRate;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public double getProductRate() {
		return productRate;
	}
	public void setProductRate(double productRate) {
		this.productRate = productRate;
	}
	
	
	
	
	

}
