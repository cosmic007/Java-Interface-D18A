package com.canddella.entity;

public class ElectronicProducts extends Product implements RepairService,ExchangeService,ReplacementService {

	

	public ElectronicProducts(String productName, String productCode, String productType, double productRate) {
		super(productName, productCode, productType, productRate);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void replaceProduct() {
		
		System.out.println(super.getProductName()+" replaced successfully");
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exchangeProduct() {
		
		System.out.println(super.getProductName()+" exchanged successfully");
		// TODO Auto-generated method stub
		
	}

	@Override
	public void repairProduct() {
		
		System.out.println(super.getProductName()+" repaired successfully");
		// TODO Auto-generated method stub
		
	}

}
