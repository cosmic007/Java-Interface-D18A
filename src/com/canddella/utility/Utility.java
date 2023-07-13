package com.canddella.utility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import com.canddella.entity.Customer;
import com.canddella.entity.Product;
import com.canddella.service.Service;

public class Utility {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		ArrayList <Product> productList = new ArrayList <>();
		ArrayList <Customer> customerList = new ArrayList <>();
		
		HashMap <String,Product> productHashMap = new HashMap<String,Product>();
		HashMap <String,Customer> customerHashMap = new HashMap<String,Customer>();
		
		Customer customer = null;
		
		
		boolean next=false;
		do
		{
			int choice =Service.displayMenu();
			
			
			switch(choice)
			{
			case 1:
				Product product=Service.createProduct();
				productList.add(product);
				productHashMap.put(product.getProductCode(), product);
				
				
				
			case 2:
				Service.displayProduct(productList);
				break;
			case 3:
				Product selectedProduct =Service.selectProduct(productHashMap);
				
				
				Boolean cusCheck=Service.checkCustomer();
				
				if(!cusCheck)
				{
					Customer newCustomer=Service.createCustomer();
					customer=newCustomer;
					Service.buyProduct(selectedProduct,newCustomer);
					customerList.add(newCustomer);
					customerHashMap.put(newCustomer.getCustomerID(), newCustomer);
					
				}
				else
				{
					Service.buyProductForExCus(customerHashMap,selectedProduct);
					
				}
				
				break;
				
			case 4:
				Service.avialServices(customerHashMap);
				break;
			default:
				break;
			
			}
			System.out.println("Do you want to continue? \n1.Yes \n2.No");
			int ans=scanner.nextInt();
			if(ans==1)
			{
				next=true;
			}
			else if(ans==2)
			{
				next=false;
				System.out.println("Thank you,Have a nice day");
			}
			else
			{
				System.out.println("Invalid choice");
			}
			
			
		}
		while(next);
		
		// TODO Auto-generated method stub

	}

}
