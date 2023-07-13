package com.canddella.entity;

public class FabricProducts extends Product implements ExchangeService {

	public FabricProducts(String productName, String productCode, String productType, double productRate) {
		super(productName, productCode, productType, productRate);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void exchangeProduct() {
		
		
		
		System.out.println(super.getProductName()+" exchanged successfully");
		// TODO Auto-generated method stub
		
	}

	

}
