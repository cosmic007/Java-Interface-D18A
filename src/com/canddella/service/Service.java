package com.canddella.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import com.canddella.entity.Customer;
import com.canddella.entity.ElectronicProducts;
import com.canddella.entity.FabricProducts;
import com.canddella.entity.Product;

public class Service {
	
	
	public static int displayMenu()
	{
		Scanner scanner = new Scanner (System.in);
		System.out.println("*********Welcome to Cosmic's Market*********");
		System.out.println("");
		System.out.println("1.Create Products\n2.Display Products\n3.Buy Products\n4.Avail Product Services\nEnter your choice:");
		int choice =scanner.nextInt();
		return choice;
		
		
	}
	
	




	public static Product createProduct() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter productName:");
		String productName = scanner.nextLine();
		System.out.println("Enter productCode:");
		String productCode=scanner.nextLine();
		System.out.println("Enter productRate:");
		double productRate =scanner.nextDouble();
		System.out.println("Select Product Type: \n1.Electronic Products \n2.Fabric Products");
		int choice = scanner.nextInt();
		Product product = null;
		switch(choice)
		{
		case 1:
			product = new ElectronicProducts(productName,productCode,"Electronic Product",productRate);
			break;
		case 2:
			product = new FabricProducts(productName,productCode,"Fabric Product",productRate);
			break;
		default:
			System.out.println("Enter a valid choice:");
			break;
			
		}
		
		
		
		// TODO Auto-generated method stub
		return product;
	}






	public static void displayProduct(ArrayList<Product> productList) {
		int count=1;
		System.out.println("No    ProductCode      ProductName       Product Type       Product Rate");
		
		for(Product product: productList)
		{
			if(product!=null)
			{
				System.out.println(count+"     "+product.getProductCode()+"      "+product.getProductName()+"       "+product.getProductType()+"        "+product.getProductRate());
				count++;
			}
			
		}
		
	}






	public static Product selectProduct(HashMap<String, Product> productHashMap) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter product code:");
		String productCode = scanner.next();
		Product product=null;
		
		if(productHashMap.get(productCode)!=null)
		{
			product = productHashMap.get(productCode);
		}
		else
		{
			System.out.println("Product code is invalid");
			
		}
		return product;
		
	}






	public static Customer createCustomer() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter customer ID");
		String customerId = scanner.nextLine();
		System.out.println("Enter customer Name");
		String customerName = scanner.nextLine();
		
		return new Customer(customerId,customerName,new ArrayList<Product>());
		
		
		
	}






	public static void buyProduct(Product selectedProduct, Customer customer) {
		
		
		customer.getProductList().add(selectedProduct);
		System.out.println("Purchased Successfully");
		// TODO Auto-generated method stub
		
	}






	public static void avialServices(HashMap<String, Customer> customerHashMap) {
		Scanner scanner = new Scanner(System.in);
		HashMap <String, Product> customerProductHashMap = new HashMap<String,Product>();
		
		System.out.println("Enter customer Id:");
		String customerId = scanner.nextLine();
		if(customerHashMap.get(customerId)!=null)
		{
			
			Customer customer = customerHashMap.get(customerId);
			if(!customer.getProductList().isEmpty())
			{
				System.out.println("Select any of the following product:");
				for(Product product:customer.getProductList())
				{
					if(product!=null)
					{
						System.out.println(product.getProductCode()+"   "+product.getProductName());
						customerProductHashMap.put(product.getProductCode(), product);
					}
				}
				System.out.println("Enter product code of your choice:");
				String productCode=scanner.nextLine();
				if(customerProductHashMap.get(productCode)!=null)
				{
					Product product = customerProductHashMap.get(productCode);
					if(product instanceof FabricProducts)
					{
						FabricProducts fabricProduct = (FabricProducts) product;
						System.out.println("Avaialable Services for your product are:\n1.Exchange\n\n0.Cancel");
						System.out.println("Enter your choice:");
						int choice=scanner.nextInt();
						if(choice==1)
						{
							fabricProduct.exchangeProduct();
							
						}
						else
						{
							System.out.println("Cancelled");
						}
						
					}
					else if(product instanceof ElectronicProducts)
					{
						ElectronicProducts electronicProduct = (ElectronicProducts) product;
						System.out.println("Avaialable Services for your product are:\n1.Exchange\n2.Replace\n3.Repair\n\n0.Cancel");
						System.out.println("Enter your choice:");
						int choice=scanner.nextInt();
						if(choice==1)
						{
							electronicProduct.exchangeProduct();
							
						}
						else if(choice==2)
						{
							electronicProduct.replaceProduct();
						}
						else if(choice==3)
						{
							electronicProduct.repairProduct();
						}
						else
						{
							System.out.println("Cancelled");
						}
						
					}
				}
				else
				{
					System.out.println("No product found under this product code");
				}
				
				
			}
			else
			{
				System.out.println("You have not purchased any products");
			}
			
		}
		
		
		
	}






	public static Boolean checkCustomer() {
		Boolean check = false;
		Scanner scanner = new Scanner(System.in);
		System.out.println("1.New Customer \n2 Existing Customer");
		int choice = scanner.nextInt();
		if(choice==1)
		{
			check=false;
			
		}
		else if(choice==2)
		{
			check=true;
		}
		else
		{
			System.out.println("Invalid choice");
			check=null;
		}
		
		// TODO Auto-generated method stub
		return check;
	}






	public static void buyProductForExCus(HashMap<String, Customer> customerHashMap, Product selectedProduct) {
		Scanner scanner =new Scanner(System.in);
		Customer customer;
		System.out.println("Enter customer id:");
		String customerId = scanner.nextLine();
		if(customerHashMap.get(customerId)!=null)
		{
			customer=customerHashMap.get(customerId);
			buyProduct(selectedProduct,customer);
			
		}
		else
		{
			System.out.println("Invalid customer id");
		}
		
	}

}
