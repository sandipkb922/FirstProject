package RetailerTransanction;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import product.Footware;
import utils.InputHelper;
import utils.Inventory;

public class TransactionProcessor {
	static private Map<Integer, TransanctionRecord> auditRecords  = new HashMap<Integer,TransanctionRecord>();
	private Integer auditListKey = Integer.valueOf(0);
	Scanner sc = InputHelper.SCANNER;
	
	public void addRecord(int serial, Inventory inventory) {
		Footware obj = inventory.getProductStore().get(serial);
		System.out.println("Number of products(Max 10 at a time): ");
		int count = Integer.parseInt(sc.nextLine());
		if (count > 0 && count <= 10){
		    System.out.println("Retailer Name: ");
		    String retailer = sc.nextLine();
		    if(obj.getCount() >= count) {
			    int remaining = obj.getCount() - count;
			    TransanctionRecord transanction = new TransanctionRecord();
			    obj.setCount(remaining);
			    transanction.setOrderCount(count);
			    transanction.setOrderObject(obj);
			    transanction.setRemainingCount(remaining);
			    transanction.setRetailerName(retailer);
			    transanction.setOrderDate();
			    auditListKey++;
			    auditRecords.put(auditListKey, transanction);
		    } else {
		    	System.out.println("Error..! Stock count unavailsble");
		    }
		} else {
			System.out.println("Maximum order reached");
		} 
			
	}

	public String toString() {
		return "AuditRecords=\n" + auditRecords;
	}

}
