package utils;

import java.util.HashMap;
import java.util.Map;

import product.Flat;
import product.Footware;
import product.Shoe;

public class Inventory {
	Map<Integer, Footware> productStore  = new HashMap<Integer,Footware>();
	private Integer productListKey = Integer.valueOf(1);

	public Map<Integer, Footware> getProductStore() {
		return productStore;
	}

	public void addProductToStore(Footware obj) {
		Footware existingRecord = null;
		Integer foundKey = Integer.valueOf(-1);
		boolean flag = false;
		
		for(Map.Entry<Integer, Footware> e: productStore.entrySet()) {
			Integer key = e.getKey();
			Footware value = e.getValue();
			
			if(value.getClass() == obj.getClass()) {
				if(value.getClass() == Flat.class) {
					Flat temp = (Flat) obj;
					if(temp.matchesWith((Flat) value)) {
						flag = true;
					}
				} else {
					Shoe temp = (Shoe) obj;
					if(temp.matchesWith((Shoe) value)) {
						flag = true;
					}
				}
			}
			if(flag) {
				existingRecord = value;
				foundKey = key;
				break;
			}
		}
		
		if(existingRecord != null) {
			int newCount = existingRecord.getCount() + obj.getCount();
			adjustProduct(foundKey, newCount);
		} else {
			productStore.put(productListKey, obj);
			productListKey++;
		}
	}

	public void viewAll() {
		for(Map.Entry<Integer, Footware> e : productStore.entrySet()) {
			System.out.println(e.getKey()+":"+e.getValue());
		}
	}

	public void adjustProduct(int serial, int newAmount) {
		Footware obj = productStore.get(Integer.valueOf(serial));
		obj.setCount(newAmount);
	}
}
