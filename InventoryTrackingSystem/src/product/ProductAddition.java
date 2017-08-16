package product;

import java.util.Scanner;

import utils.InputHelper;

public class ProductAddition {
		
	public static Footware addProduct() {
		Scanner sc = InputHelper.SCANNER;
		Footware obj = null;
		
		System.out.println("1.Flatware 2.Shoe? ");
		String option = sc.nextLine();
		if(option.equals("1")) {
			obj = new Flat();
		} else {
			obj = new Shoe();
		}
		obj.getInput();
		return obj;
	}
}
