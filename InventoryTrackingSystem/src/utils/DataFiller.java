package utils;

import product.Flat;
import product.Shoe;

public class DataFiller {
	public static void fillRecords(Inventory targetInventory) {
		Shoe shoe = new Shoe();
		Flat flat = new Flat();
		
		shoe.setBrand("Puma");
		shoe.setCategory("M");
		shoe.setCount(100);
		shoe.setSize(10);
		shoe.setType("Canvas");
		targetInventory.addProductToStore(shoe);
		shoe = new Shoe();
		
		flat.setBrand("Puma");
		flat.setCategory("M");
		flat.setCount(200);
		flat.setSize(10);
		flat.setColor("Beige");
		targetInventory.addProductToStore(flat);	
		flat = new Flat();
		
		flat.setBrand("Nike");
		flat.setCategory("W");
		flat.setCount(150);
		flat.setSize(7);
		flat.setColor("Blue");
		targetInventory.addProductToStore(flat);	
		flat = new Flat();
		
		shoe.setBrand("Adidas");
		shoe.setCategory("M");
		shoe.setCount(500);
		shoe.setSize(8);
		shoe.setType("Sports");
		targetInventory.addProductToStore(shoe);
		shoe = new Shoe();
		
		shoe.setBrand("Nike");
		shoe.setCategory("W");
		shoe.setCount(80);
		shoe.setSize(8);
		shoe.setType("Sports");
		targetInventory.addProductToStore(shoe);
		shoe = new Shoe();
		
		flat.setBrand("Puma");
		flat.setCategory("W");
		flat.setCount(130);
		flat.setSize(7);
		flat.setColor("Blue");
		targetInventory.addProductToStore(flat);	
		flat = new Flat();
		
		flat.setBrand("Puma");
		flat.setCategory("W");
		flat.setCount(130);
		flat.setSize(7);
		flat.setColor("Black");
		targetInventory.addProductToStore(flat);	
		flat = new Flat();
	}
}
