package controller;

import java.util.Scanner;

import RetailerTransanction.TransactionProcessor;
import product.Footware;
import product.ProductAddition;
import utils.DataFiller;
import utils.InputHelper;
import utils.Inventory;

public class DataWarehouse {
	public static void main(String args[]){
		Inventory myInventory = new Inventory();
		TransactionProcessor transanction = new TransactionProcessor();
		
		boolean processFlow = true;
		Scanner sc = InputHelper.SCANNER;
		String option = null;
		DataFiller.fillRecords(myInventory);
		while(processFlow) {
			
			System.out.println("1. View Inventory\n"
					+ "2. Adjust Inventory\n"
					+ "3. Add Stock\n"
					+ "4. Place Order\n"
					+ "5. View Audit Trails\n"
					+ "6. Exit\n"
					+ "\nYour choice: ");
			option = sc.nextLine();
			switch(option) {
				case "1":	myInventory.viewAll();
							break;
				case "2":   myInventory.viewAll();
				            System.out.println("Enter product number to adjust: ");
				            int serial = Integer.parseInt(sc.nextLine());
				            System.out.println("Enter the new count: ");
				            int newAmount = Integer.parseInt(sc.nextLine());
				            myInventory.adjustProduct(serial, newAmount);
				            System.out.println("Product adjusted successfully");
							break;
				case "3":   Footware obj = ProductAddition.addProduct();
							myInventory.addProductToStore(obj);
							System.out.println("Products added successfully");
							break;
				case "4":   myInventory.viewAll();
	            			System.out.println("Enter product number to place order: ");
	            			int productKey = Integer.parseInt(sc.nextLine());
							transanction.addRecord(productKey, myInventory);
							System.out.println("Order placed successfully");
					        break;
				case "5":   System.out.println("Audit details\n");
					        System.out.println(transanction);
							break;
				case "6":   System.out.println("Program Terminated");
							processFlow = false;
							break;
				default : 	System.out.println("Wrong choice entered. Enter Again");
							break;
			}
		}
	}
}
