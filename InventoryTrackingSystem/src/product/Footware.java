package product;

import java.util.Scanner;

import utils.InputHelper;

public abstract class Footware {
	Scanner sc = InputHelper.SCANNER;
	protected String brand;
	protected String category;
	protected int size;
	protected int count = 0;

	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getBrand() {
		return brand;
	}
	public String getCategory() {
		return category;
	}
	public int getSize() {
		return size;
	}
	
	public void setBrand(String brand) {
		this.brand=brand;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
	
	@Override
	public String toString() {
		return "Footware [brand=" + brand + ", category=" + category + ", size=" + size + ", count=" + count + "]";
	}
	public void getInput() {
		System.out.println("Number of products: ");
		this.setCount(Integer.parseInt(sc.nextLine()));
		System.out.println("Brand: ");
		this.setBrand(sc.nextLine());
		System.out.println("Category: ");
		this.setCategory(sc.nextLine());
		System.out.println("Size: ");
		this.setSize(Integer.parseInt(sc.nextLine()));
	}
}

